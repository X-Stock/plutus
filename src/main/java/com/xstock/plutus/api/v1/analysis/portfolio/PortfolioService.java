package com.xstock.plutus.api.v1.analysis.portfolio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.api.v1.stock.industry.IndustryService;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalService;
import com.xstock.plutus.grpc.GrpcClient;
import com.xstock.plutus.utils.dto.StockHistoricalReturnsDto;
import com.xstock.plutus.utils.exception.GrpcResponseException;
import com.xstock.proto.optimizePortfolio.Asset;
import com.xstock.proto.optimizePortfolio.OptimizedPortfolioRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "portfolio")
public class PortfolioService {
    private final GrpcClient grpcClient;

    private final IndustryService industryService;

    private final StockHistoricalService stockHistoricalService;

    private final ObjectMapper objectMapper;

    private List<String> getTickers(List<String> industries) {
        List<Company> companies = industries
                .stream()
                .flatMap(industry ->
                        industryService
                                .getCompaniesByIndustry(industry, null, true)
                                .content()
                                .stream())
                .toList();
        return companies.stream().map(Company::getTicker).toList();
    }

    private List<Asset> createAssetList(
            List<String> tickers,
            OffsetDateTime fromDate,
            OffsetDateTime toDate
    ) throws Exception {
        List<Asset> assets = new ArrayList<>(tickers.size());
        for (String ticker : tickers) {
            var historical = stockHistoricalService
                    .getAllByTicker(ticker, fromDate, toDate, null, true)
                    .content();

            List<Struct> historicalStructs = new ArrayList<>(historical.size());
            for (var data : historical) {
                Struct.Builder structBuilder = Struct.newBuilder();
                JsonFormat.parser().merge(objectMapper.writeValueAsString(data), structBuilder);
                historicalStructs.add(structBuilder.build());
            }
            assets.add(Asset.newBuilder().setTicker(ticker).addAllHistorical(historicalStructs).build());
        }
        return assets;
    }

    @Cacheable
    public String getOptimizedPortfolio(
            PortfolioRequest portfolio,
            OffsetDateTime fromDate,
            OffsetDateTime toDate
    ) {
        List<String> tickers = portfolio.tickers().isEmpty()
                ? getTickers(portfolio.industries())
                : portfolio.tickers();

        try {
            List<Asset> assets = createAssetList(tickers, fromDate, toDate);
            OptimizedPortfolioRequest request = OptimizedPortfolioRequest.newBuilder()
                    .addAllAssets(assets)
                    .setObjective(portfolio.objective())
                    .build();

            var response = grpcClient.optimizePortfolio(request);
            var optimizedPortfolio = response.orElseThrow(GrpcResponseException::new);
            return JsonFormat.printer().print(optimizedPortfolio);
        } catch (Exception e) {
            throw new GrpcResponseException(e.getMessage());
        }
    }

    @Cacheable
    public List<IntersectedHistorical> intersectHistorical(
            Set<String> tickers,
            String interval,
            OffsetDateTime fromDate,
            OffsetDateTime toDate
    ) {
        Map<String, List<StockHistoricalReturns>> historical = tickers
                .parallelStream()
                .collect(Collectors.toMap(
                        ticker -> ticker,
                        ticker -> stockHistoricalService
                                .getReturnsByTicker(ticker, interval, fromDate, toDate, null, true)
                                .content()
                ));

        Set<Instant> intersectTime = historical.values().parallelStream()
                .map(stockHistoricalReturns -> stockHistoricalReturns
                        .stream()
                        .map(StockHistoricalReturns::getTime)
                        .collect(Collectors.toSet()))
                .reduce((set1, set2) -> {
                            set1.retainAll(set2);
                            return set1;
                        })
                .orElseGet(HashSet::new);

        return historical.entrySet()
                .parallelStream()
                .map(entry ->
                        new IntersectedHistorical(
                                entry.getKey(),
                                entry.getValue().parallelStream()
                                        .filter(stockHistoricalReturns ->
                                                intersectTime.contains(stockHistoricalReturns.getTime()))
                                        .toList()
                        ))
                .toList();
    }

    @Cacheable
    public List<StockHistoricalReturns> getPortfolioReturns(
            List<PortfolioReturnsRequest> request,
            String interval,
            OffsetDateTime fromDate,
            OffsetDateTime toDate
    ) {
        Map<String, Float> portfolio = request
                .stream()
                .collect(Collectors.toUnmodifiableMap(PortfolioReturnsRequest::ticker, PortfolioReturnsRequest::weight));
        List<IntersectedHistorical> intersectedHistorical = intersectHistorical(portfolio.keySet(), interval, fromDate, toDate);

        int timePoints = intersectedHistorical.getFirst().historical().size();
        return IntStream.iterate(timePoints - 1, i -> i - 1)
                .limit(timePoints)
                .mapToObj(i -> {
                    Instant time = intersectedHistorical.getFirst().historical().get(i).getTime();
                    float returns = intersectedHistorical.parallelStream()
                        .reduce(0f,
                                (subtotal, company) -> subtotal +
                                        company.historical().get(i).getReturns() * portfolio.get(company.ticker()),
                                Float::sum
                        );
                    return (StockHistoricalReturns) new StockHistoricalReturnsDto(time, returns);
                })
                .toList();
    }
}

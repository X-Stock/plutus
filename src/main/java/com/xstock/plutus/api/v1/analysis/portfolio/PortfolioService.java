package com.xstock.plutus.api.v1.analysis.portfolio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import com.xstock.plutus.api.v1.analysis.intersectHistorical.IntersectedHistorical;
import com.xstock.plutus.api.v1.analysis.intersectHistorical.IntersectedHistoricalService;
import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.api.v1.stock.industry.IndustryService;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistorical;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import com.xstock.plutus.grpc.GrpcClient;
import com.xstock.plutus.utils.dto.StockHistoricalReturnsDTO;
import com.xstock.plutus.utils.exception.GrpcResponseException;
import com.xstock.proto.optimizePortfolio.Asset;
import com.xstock.proto.optimizePortfolio.OptimizedPortfolioRequest;
import com.xstock.proto.optimizePortfolio.OptimizedPortfolioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "portfolio")
public class PortfolioService {
    private final GrpcClient grpcClient;

    private final IndustryService industryService;

    private final IntersectedHistoricalService intersectedHistoricalService;

    private final ObjectMapper objectMapper;

    private Set<String> getTickers(Set<String> industries) {
        Set<Company> companies = industries
                .stream()
                .flatMap(industry ->
                        industryService
                                .getCompaniesByIndustry(industry, null, true)
                                .content()
                                .stream())
                .collect(Collectors.toUnmodifiableSet());
        return companies.stream().map(Company::getTicker).collect(Collectors.toUnmodifiableSet());
    }

    private List<Asset> createAssetList(
            Set<String> tickers,
            Instant fromDate,
            Instant toDate
    ) {
        List<IntersectedHistorical<StockHistorical>> intersectedHistorical = intersectedHistoricalService.intersectHistoricalPrices(tickers, fromDate, toDate);

        return intersectedHistorical.parallelStream()
                .map(item ->
                        Asset.newBuilder()
                                .setTicker(item.ticker())
                                .addAllHistorical(item.historical().stream()
                                        .map(historical -> {
                                            Struct.Builder structBuilder = Struct.newBuilder();
                                            try {
                                                JsonFormat.parser().merge(objectMapper.writeValueAsString(historical), structBuilder);
                                            } catch (InvalidProtocolBufferException | JsonProcessingException e) {
                                                throw new GrpcResponseException(e.getMessage());
                                            }
                                            return structBuilder.build();
                                        })
                                        .toList()
                                )
                                .build())
                .toList();
    }

    @Cacheable
    public String getOptimizedPortfolio(
            PortfolioRequest portfolio,
            Instant fromDate,
            Instant toDate
    ) {
        Set<String> tickers = portfolio.tickers().isEmpty()
                ? getTickers(portfolio.industries())
                : portfolio.tickers();
        List<Asset> assets = createAssetList(tickers, fromDate, toDate);

        try {
            OptimizedPortfolioRequest request = OptimizedPortfolioRequest.newBuilder()
                    .addAllAssets(assets)
                    .setObjective(portfolio.objective())
                    .build();

            OptimizedPortfolioResponse optimizedPortfolio = grpcClient
                    .optimizePortfolio(request)
                    .orElseThrow(GrpcResponseException::new);
            return JsonFormat.printer().print(optimizedPortfolio);
        } catch (Exception e) {
            throw new GrpcResponseException(e.getMessage());
        }
    }

    @Cacheable
    public List<StockHistoricalReturns> getPortfolioReturns(
            Set<PortfolioReturnsRequest> request,
            String interval,
            Instant fromDate,
            Instant toDate,
            boolean cumulative
    ) {
        Map<String, Float> portfolio = request
                .stream()
                .collect(Collectors.toUnmodifiableMap(PortfolioReturnsRequest::ticker, PortfolioReturnsRequest::weight));
        List<IntersectedHistorical<StockHistoricalReturns>> intersectedHistorical = intersectedHistoricalService.intersectHistoricalReturns(portfolio.keySet(), interval, fromDate, toDate);

        int timePoints = intersectedHistorical.getFirst().historical().size();
        List<StockHistoricalReturns> portfolioReturns =  IntStream.iterate(timePoints - 1, i -> i - 1)
                .limit(timePoints)
                .mapToObj(i -> {
                    Instant time = intersectedHistorical.getFirst().historical().get(i).getTime();
                    float returns = intersectedHistorical.parallelStream()
                        .reduce(0f,
                                (subtotal, company) -> subtotal +
                                        company.historical().get(i).getReturns() * portfolio.get(company.ticker()),
                                Float::sum
                        );
                    return (StockHistoricalReturns) new StockHistoricalReturnsDTO(time, returns);
                })
                .toList();

        if (cumulative) {
            AtomicReference<Float> cumulativeReturns = new AtomicReference<>(1f);
            return portfolioReturns.stream().map(returns ->
                            (StockHistoricalReturns) new StockHistoricalReturnsDTO(
                                    returns.getTime(),
                                    cumulativeReturns.updateAndGet(v -> v * (1f + returns.getReturns()))
                            ))
                    .toList();
        }
        return portfolioReturns;
    }
}

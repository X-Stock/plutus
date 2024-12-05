package com.xstock.plutus.api.v1.ai.optimizePortfolio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import com.xstock.grpcProto.optimizePortfolio.Asset;
import com.xstock.grpcProto.optimizePortfolio.OptimizedPortfolioRequest;
import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.api.v1.stock.company.CompanyService;
import com.xstock.plutus.api.v1.stock.industry.IndustryService;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalService;
import com.xstock.plutus.grpc.GrpcClient;
import com.xstock.plutus.utils.exception.GrpcResponseException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "optimizePortfolio")
public class OptimizePortfolioService {
    private final GrpcClient grpcClient;

    private final CompanyService companyService;

    private final IndustryService industryService;

    private final StockHistoricalService stockHistoricalService;

    private final PageRequest defaultPageRequest;

    private final ObjectMapper objectMapper;

    private List<String> getTickers(String industry) {
        List<Company> companies = industry.equals("all")
                ? companyService.getAll(defaultPageRequest, true).content()
                : industryService.getCompaniesByIndustry(industry, defaultPageRequest, true).content();

        List<String> tickers = new ArrayList<>(companies.size());
        companies.forEach(company -> tickers.add(company.getTicker()));
        return tickers;
    }

    private List<Asset> createAssetList(List<String> tickers) throws Exception {
        List<Asset> assets = new ArrayList<>(tickers.size());
        for (String ticker : tickers) {
            var historical = stockHistoricalService
                    .getAllByTicker(ticker, defaultPageRequest, true)
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
    public String getOptimizedPortfolio(OptimizePortfolio portfolio) {
        List<String> tickers = portfolio.tickers().isEmpty()
                ? getTickers(portfolio.industry())
                : portfolio.tickers();

        try {
            List<Asset> assets = createAssetList(tickers);
            OptimizedPortfolioRequest request = OptimizedPortfolioRequest.newBuilder()
                    .addAllAssets(assets)
                    .setObjective(portfolio.objective())
                    .setCapital(portfolio.capital())
                    .build();

            var response = grpcClient.optimizePortfolio(request);
            var optimizedPortfolio = response.orElseThrow(GrpcResponseException::new);
            return JsonFormat.printer().print(optimizedPortfolio);
        } catch (Exception e) {
            throw new GrpcResponseException(e.getMessage());
        }
    }
}

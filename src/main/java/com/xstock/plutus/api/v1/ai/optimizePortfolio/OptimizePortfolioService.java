package com.xstock.plutus.api.v1.ai.optimizePortfolio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import com.xstock.grpcProto.optimizePortfolio.Asset;
import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.api.v1.stock.company.CompanyService;
import com.xstock.plutus.api.v1.stock.industry.IndustryService;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalService;
import com.xstock.plutus.utils.exception.GrpcResponseException;
import com.xstock.plutus.grpc.GrpcClient;
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

    private List<String> getTickers(OptimizePortfolio portfolio) {
        List<String> tickers;
        if (portfolio.tickers().isEmpty()) {
            List<Company> companies = portfolio.industry().equals("all")
                    ? companyService.getAll(defaultPageRequest, true).content()
                    : industryService.getCompaniesByIndustry(portfolio.industry(), defaultPageRequest, true).content();
            tickers = new ArrayList<>(companies.size());
            companies.forEach(company -> tickers.add(company.getTicker()));
        } else {
            tickers = portfolio.tickers();
        }
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
        List<String> tickers = getTickers(portfolio);

        try {
            List<Asset> assets = createAssetList(tickers);
            var response = grpcClient.optimizePortfolio(assets);
            var optimizedPortfolio = response.orElseThrow(GrpcResponseException::new);
            return JsonFormat.printer().print(optimizedPortfolio);
        } catch (Exception e) {
            throw new GrpcResponseException(e.getMessage());
        }
    }
}

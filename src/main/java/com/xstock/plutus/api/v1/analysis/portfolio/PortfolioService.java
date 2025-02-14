package com.xstock.plutus.api.v1.analysis.portfolio;

import com.xstock.plutus.api.v1.analysis.intersectHistorical.IntersectHistoricalReturnsRequest;
import com.xstock.plutus.api.v1.analysis.intersectHistorical.IntersectedHistorical;
import com.xstock.plutus.api.v1.analysis.intersectHistorical.IntersectedHistoricalService;
import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.api.v1.stock.industry.IndustryService;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import com.xstock.plutus.config.rabbitmq.RabbitMqClient;
import com.xstock.plutus.utils.dto.StockHistoricalReturnsDTO;
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
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "portfolio")
public class PortfolioService {
    private final RabbitMqClient rabbitMqClient;

    private final IndustryService industryService;

    private final IntersectedHistoricalService intersectedHistoricalService;

    private Set<String> getTickers(Set<String> industries) {
        Stream<Company> companies = industries
                .parallelStream()
                .flatMap(industry -> industryService
                        .getCompaniesByIndustry(industry, null, true)
                        .content()
                        .stream());
        return companies.map(Company::getTicker).collect(Collectors.toUnmodifiableSet());
    }

    @Cacheable
    public String getOptimizedPortfolio(PortfolioRequest request) {
        Set<String> tickers = request.tickers().isEmpty()
                ? getTickers(request.industries())
                : request.tickers();
        return rabbitMqClient.sendAndReceive(
                new PortfolioRequestDto(
                        tickers,
                        request.objective(),
                        request.capital(),
                        request.fromDate(),
                        request.toDate()),
                "optimize_portfolio");
    }

    @Cacheable
    public List<StockHistoricalReturns> getPortfolioReturns(
            PortfolioReturnsRequest request
    ) {
        Map<String, Float> portfolio = request.assets().stream()
                .collect(Collectors.toUnmodifiableMap(Asset::ticker, Asset::weight));
        
        List<IntersectedHistorical<StockHistoricalReturns>> intersectedHistorical = intersectedHistoricalService
                .intersectHistoricalReturns(new IntersectHistoricalReturnsRequest(
                        portfolio.keySet(),
                        request.interval(),
                        request.fromDate(),
                        request.toDate()
                ));
        Stream<StockHistoricalReturns> portfolioReturns = getPortfolioReturnsStream(intersectedHistorical, portfolio);

        if (request.isCumulative()) {
            AtomicReference<Float> cumulativeReturns = new AtomicReference<>(1f);
            return portfolioReturns.map(returns ->
                            (StockHistoricalReturns) new StockHistoricalReturnsDTO(
                                    returns.getTime(),
                                    cumulativeReturns.updateAndGet(v -> v * (1f + returns.getReturns()))
                            ))
                    .toList();
        }
        return portfolioReturns.toList();
    }

    private static Stream<StockHistoricalReturns> getPortfolioReturnsStream(List<IntersectedHistorical<StockHistoricalReturns>> intersectedHistorical, Map<String, Float> portfolio) {
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
                    return new StockHistoricalReturnsDTO(time, returns);
                });
    }
}

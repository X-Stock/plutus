package com.xstock.plutus.api.v1.analysis.portfolio;

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

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "portfolio")
public class PortfolioService {
    private final RabbitMqClient rabbitMqClient;

    private final IndustryService industryService;

    private final IntersectedHistoricalService intersectedHistoricalService;

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

    @Cacheable
    public String getOptimizedPortfolio(
            PortfolioRequest portfolio,
            Instant fromDate,
            Instant toDate
    ) {
        Set<String> tickers = portfolio.tickers().isEmpty()
                ? getTickers(portfolio.industries())
                : portfolio.tickers();
        return rabbitMqClient.sendAndReceive(
                new PortfolioRequestDto(tickers, portfolio.objective(), portfolio.capital(), fromDate, toDate),
                "optimize_portfolio"
        );
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

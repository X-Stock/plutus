package com.xstock.plutus.api.v1.analysis.portfolio;

import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping(path = "/optimize", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOptimizedPortfolio(@RequestBody PortfolioRequest portfolio) {
        return portfolioService.getOptimizedPortfolio(portfolio);
    }

    @PostMapping(path = "/intersect-historical")
    public List<IntersectedHistorical> getIntersection(
            @RequestBody Set<String> tickers,
            @RequestParam String interval
    ) {
        return portfolioService.intersectHistorical(tickers, interval);
    }

    @PostMapping(path ="/historical-returns")
    public List<StockHistoricalReturns> getPortfolioReturns(
            @RequestBody List<PortfolioReturnsRequest> request,
            @RequestParam String interval
    ) {
        return portfolioService.getPortfolioReturns(request, interval);
    }
}

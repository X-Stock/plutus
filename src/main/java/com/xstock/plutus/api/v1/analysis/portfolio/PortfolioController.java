package com.xstock.plutus.api.v1.analysis.portfolio;

import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping(path = "/optimize", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOptimizedPortfolio(
            @RequestBody PortfolioRequest portfolio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return portfolioService.getOptimizedPortfolio(portfolio, start, end);
    }

    @PostMapping(path = "/intersect-historical")
    public List<IntersectedHistorical> getIntersection(
            @RequestBody Set<String> tickers,
            @RequestParam String interval,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return portfolioService.intersectHistorical(tickers, interval, start, end);
    }

    @PostMapping(path ="/historical-returns")
    public List<StockHistoricalReturns> getPortfolioReturns(
            @RequestBody List<PortfolioReturnsRequest> request,
            @RequestParam String interval,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return portfolioService.getPortfolioReturns(request, interval, start, end);
    }
}

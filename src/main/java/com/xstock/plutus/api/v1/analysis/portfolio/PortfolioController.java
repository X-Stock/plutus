package com.xstock.plutus.api.v1.analysis.portfolio;

import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
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
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            Instant fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            Instant toDate
    ) {
        return portfolioService.getOptimizedPortfolio(portfolio, fromDate, toDate);
    }

    @PostMapping(path ="/historical-returns")
    public List<StockHistoricalReturns> getPortfolioReturns(
            @RequestBody Set<PortfolioReturnsRequest> request,
            @RequestParam String interval,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            Instant fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            Instant toDate,
            @RequestParam(defaultValue = "false") boolean cumulative
    ) {
        return portfolioService.getPortfolioReturns(request, interval, fromDate, toDate, cumulative);
    }
}

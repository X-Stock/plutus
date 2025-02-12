package com.xstock.plutus.api.v1.analysis.portfolio;

import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping(path = "/optimize", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOptimizedPortfolio(@RequestBody @Valid PortfolioRequest request) {
        return portfolioService.getOptimizedPortfolio(request);
    }

    @PostMapping(path ="/historical-returns")
    public List<StockHistoricalReturns> getPortfolioReturns(
            @RequestBody @Valid PortfolioReturnsRequest request
    ) {
        return portfolioService.getPortfolioReturns(request);
    }
}

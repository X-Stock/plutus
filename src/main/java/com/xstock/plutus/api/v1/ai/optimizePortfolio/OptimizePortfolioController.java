package com.xstock.plutus.api.v1.ai.optimizePortfolio;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/optimize-portfolio")
public class OptimizePortfolioController {
    private final OptimizePortfolioService optimizePortfolioService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOptimizedPortfolio(@RequestBody OptimizePortfolio portfolio) {
        return optimizePortfolioService.getOptimizedPortfolio(portfolio);
    }
}

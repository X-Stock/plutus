package com.xstock.plutus.api.v1.ai.optimizePortfolio;

import java.util.List;

public record OptimizePortfolio(
        String industry,
        List<String> tickers,
        String objective,
        Long capital
) { }

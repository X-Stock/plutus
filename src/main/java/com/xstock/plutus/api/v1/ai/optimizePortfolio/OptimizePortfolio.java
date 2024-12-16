package com.xstock.plutus.api.v1.ai.optimizePortfolio;

import java.util.List;

public record OptimizePortfolio(
        List<String> industries,
        List<String> tickers,
        String objective,
        Long capital
) {
}

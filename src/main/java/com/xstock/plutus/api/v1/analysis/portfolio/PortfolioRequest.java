package com.xstock.plutus.api.v1.analysis.portfolio;

import java.util.Set;

public record PortfolioRequest(
        Set<String> industries,
        Set<String> tickers,
        String objective,
        Long capital
) {
}

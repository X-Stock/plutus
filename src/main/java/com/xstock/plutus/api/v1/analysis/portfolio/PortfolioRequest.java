package com.xstock.plutus.api.v1.analysis.portfolio;

import java.util.List;

public record PortfolioRequest(
        List<String> industries,
        List<String> tickers,
        String objective,
        Long capital
) {
}

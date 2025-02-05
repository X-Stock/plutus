package com.xstock.plutus.api.v1.analysis.portfolio;

import java.time.Instant;
import java.util.Set;

public record PortfolioRequestDto(
        Set<String> tickers,
        String objective,
        Long capital,
        Instant fromDate,
        Instant toDate
) { }

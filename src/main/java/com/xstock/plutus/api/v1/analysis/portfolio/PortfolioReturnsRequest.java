package com.xstock.plutus.api.v1.analysis.portfolio;

public record PortfolioReturnsRequest(
        String ticker,
        Float weight
) {}

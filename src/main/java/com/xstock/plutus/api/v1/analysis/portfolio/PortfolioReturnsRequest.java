package com.xstock.plutus.api.v1.analysis.portfolio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record PortfolioReturnsRequest(
        @NotBlank String ticker,
        @PositiveOrZero Float weight
) {}

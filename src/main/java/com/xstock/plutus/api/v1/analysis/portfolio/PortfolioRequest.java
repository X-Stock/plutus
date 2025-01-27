package com.xstock.plutus.api.v1.analysis.portfolio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.util.Set;

public record PortfolioRequest(
        @NotEmpty Set<@NotBlank String> industries,
        Set<@NotBlank String> tickers,
        @NotBlank
        @Pattern(regexp = "max_ratio|max_return|min_risk", message = "must be 'max_ratio', 'max_return' or 'min_risk'")
        String objective,
        @Positive Long capital
) {
}

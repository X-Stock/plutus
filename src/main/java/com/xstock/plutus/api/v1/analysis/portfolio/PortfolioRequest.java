package com.xstock.plutus.api.v1.analysis.portfolio;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Set;

public record PortfolioRequest(
        @NotEmpty
        Set<@NotBlank String> industries,

        Set<@NotBlank String> tickers,

        @NotBlank
        @Pattern(regexp = "max_ratio|max_return|min_risk",
                message = "must be 'max_ratio', 'max_return' or 'min_risk'")
        String objective,

        @NotNull @Positive
        Long capital,

        @Past
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant fromDate,

        @PastOrPresent
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant toDate
) {
}

package com.xstock.plutus.api.v1.analysis.portfolio;

import com.xstock.plutus.utils.validations.constraints.HistoricalIntervalConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Set;

public record PortfolioReturnsRequest(
        @NotEmpty
        Set<Asset> assets,

        @HistoricalIntervalConstraint
        String interval,

        @Past
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant fromDate,

        @PastOrPresent
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant toDate,

        @NotNull
        boolean isCumulative
) {}
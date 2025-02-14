package com.xstock.plutus.api.v1.analysis.intersectHistorical;

import com.xstock.plutus.utils.validations.constraints.HistoricalIntervalConstraint;
import com.xstock.plutus.utils.validations.constraints.IntersectTickerConstraint;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Set;

public record IntersectHistoricalReturnsRequest (
        @IntersectTickerConstraint
        Set<String> tickers,

        @HistoricalIntervalConstraint
        String interval,

        @Past
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant fromDate,

        @PastOrPresent
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant toDate
) {}

package com.xstock.plutus.api.v1.analysis.intersectHistorical;

import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistorical;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import com.xstock.plutus.utils.validations.constraints.HistoricalIntervalConstraint;
import com.xstock.plutus.utils.validations.constraints.IntersectTickerConstraint;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/intersect-historical")
public class IntersectedHistoricalController {
    private final IntersectedHistoricalService intersectedHistoricalService;

    @PostMapping
    public List<IntersectedHistorical<StockHistorical>> getIntersectedHistoricalPrice(
            @RequestBody @IntersectTickerConstraint Set<String> tickers,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @Past Instant fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @PastOrPresent Instant toDate
    ) {
        return intersectedHistoricalService.intersectHistoricalPrices(tickers, fromDate, toDate);
    }

    @PostMapping(path = "/returns")
    public List<IntersectedHistorical<StockHistoricalReturns>> getIntersectedHistoricalReturns(
            @RequestBody @IntersectTickerConstraint Set<String> tickers,
            @RequestParam @HistoricalIntervalConstraint String interval,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @Past Instant fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @PastOrPresent Instant toDate
    ) {
        return intersectedHistoricalService.intersectHistoricalReturns(tickers, interval, fromDate, toDate);
    }
}

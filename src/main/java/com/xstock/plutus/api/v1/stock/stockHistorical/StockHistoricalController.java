package com.xstock.plutus.api.v1.stock.stockHistorical;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.validations.constraints.HistoricalIntervalConstraint;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}/stock-historical")
public class StockHistoricalController {
    private final StockHistoricalService stockHistoricalService;

    @GetMapping
    public PaginatedResponse<StockHistorical> getAllByTicker(
            @PathVariable String ticker,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @Past Instant fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @PastOrPresent Instant startDate,
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged
    ) {
        return stockHistoricalService.getAllByTicker(ticker, fromDate, startDate, pageable, unpaged);
    }

    @GetMapping(path = "/returns")
    public PaginatedResponse<StockHistoricalReturns> getReturns(
            @PathVariable String ticker,
            @RequestParam @HistoricalIntervalConstraint String interval,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @Past Instant fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @PastOrPresent Instant toDate,
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged
    ) {
        return stockHistoricalService.getReturnsByTicker(ticker, interval, fromDate, toDate, pageable, unpaged);
    }
}

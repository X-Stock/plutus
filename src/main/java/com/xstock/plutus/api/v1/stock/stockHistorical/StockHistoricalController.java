package com.xstock.plutus.api.v1.stock.stockHistorical;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}/stock-historical")
public class StockHistoricalController {
    private final StockHistoricalService stockHistoricalService;

    @GetMapping
    public PaginatedResponse<StockHistorical> getAllByTicker(
            @PathVariable String ticker,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            OffsetDateTime fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            OffsetDateTime startDate,
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged
    ) {
        return stockHistoricalService.getAllByTicker(ticker, fromDate, startDate, pageable, unpaged);
    }

    @GetMapping(path = "/returns")
    public PaginatedResponse<StockHistoricalReturns> getReturns(
            @PathVariable String ticker,
            @RequestParam String interval,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            OffsetDateTime fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            OffsetDateTime toDate,
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged
    ) {
        return stockHistoricalService.getReturnsByTicker(ticker, interval, fromDate, toDate, pageable, unpaged);
    }
}

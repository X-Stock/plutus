package com.xstock.plutus.api.v1.stock.stockHistorical;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}/stock-historical")
public class StockHistoricalController implements CommonController<StockHistorical> {
    private final StockHistoricalService stockHistoricalService;

    @Override
    @GetMapping
    public PaginatedResponse<StockHistorical> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return stockHistoricalService.getAllByTicker(ticker, pageable, unpaged);
    }

    @GetMapping(path = "/range")
    public PaginatedResponse<StockHistorical> getAllByTickerInRange(
            @PathVariable String ticker,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
            Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged
    ) {
        return stockHistoricalService.getAllByTickerInRange(ticker,  start, end, pageable, unpaged);
    }

    @GetMapping(path = "/returns")
    public PaginatedResponse<StockHistoricalReturns> getReturnsWithInterval(
            @PathVariable String ticker,
            @RequestParam String interval,
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged
    ) {
        return stockHistoricalService.getReturnsByTicker(ticker, interval, pageable, unpaged);
    }
}

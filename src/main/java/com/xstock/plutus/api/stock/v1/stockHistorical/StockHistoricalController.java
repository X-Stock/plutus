package com.xstock.plutus.api.stock.v1.stockHistorical;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class StockHistoricalController implements CommonController<StockHistorical> {
    private final StockHistoricalService stockHistoricalService;

    @Override
    @GetMapping(path = "/stockHistorical")
    public PaginatedResponse<StockHistorical> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return stockHistoricalService.getAllByTicker(ticker, pageable);
    }
}

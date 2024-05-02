package com.xstock.plutus.v1.stockHistorical;

import com.xstock.plutus.utils.interfaces.controller.MultiResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class StockHistoricalController implements MultiResponseController<StockHistorical> {
    private final StockHistoricalService stockHistoricalService;

    @Override
    @GetMapping(path = "/stockHistorical")
    public Iterable<StockHistorical> getAllByTicker(@PathVariable String ticker) {
        return stockHistoricalService.getAllByTicker(ticker);
    }
}

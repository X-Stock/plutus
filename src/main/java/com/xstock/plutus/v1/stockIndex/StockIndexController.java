package com.xstock.plutus.v1.stockIndex;

import com.xstock.plutus.utils.interfaces.controller.MultiResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class StockIndexController implements MultiResponseController<StockIndex> {
    private final StockIndexService stockIndexService;

    @Override
    @GetMapping(path = "/companies/{ticker}/stockIndices")
    public Iterable<StockIndex> getAllByTicker(@PathVariable String ticker) {
        return stockIndexService.getAllByTicker(ticker);
    }

    @GetMapping(path = "/stockIndices")
    public Iterable<StockIndex> getAll() {
        return stockIndexService.getAll();
    }
}

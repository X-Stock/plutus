package com.xstock.plutus.v1.stockIndex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class StockIndexController {
    @Autowired
    private StockIndexService stockIndexService;

    @GetMapping("/stockIndices")
    public Iterable<StockIndex> getAllByTicker(@PathVariable String ticker) {
        return stockIndexService.getAllByTicker(ticker);
    }
}

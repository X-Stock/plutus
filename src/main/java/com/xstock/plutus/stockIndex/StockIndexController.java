package com.xstock.plutus.stockIndex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/stockIndices")
public class StockIndexController {
    @Autowired
    private StockIndexService stockIndexService;

    @GetMapping
    public Iterable<StockIndex> getStockIndices() {
        return stockIndexService.getStockIndices();
    }

    @PostMapping(path = "/add")
    public String addNewStockIndex(@RequestBody StockIndex stockIndex) {
        return stockIndexService.addNewStockIndex(stockIndex);
    }
}

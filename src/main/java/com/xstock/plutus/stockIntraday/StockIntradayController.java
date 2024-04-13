package com.xstock.plutus.stockIntraday;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/stockIntraday")
public class StockIntradayController {
    @Autowired
    private StockIntradayService stockIntradayService;

    @GetMapping
    public Iterable<StockIntraday> getStockIntraday() {
        return stockIntradayService.getStockIntraday();
    }

    @PostMapping(path = "/add")
    public String addNewStockIntraday(@RequestBody StockIntraday stockIntraday) {
        return stockIntradayService.addNewStockIntraday(stockIntraday);
    }
}

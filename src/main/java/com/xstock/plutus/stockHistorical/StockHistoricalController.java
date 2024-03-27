package com.xstock.plutus.stockHistorical;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/stockHistorical")
public class StockHistoricalController {
    @Autowired
    private StockHistoricalService stockHistoricalService;

    @GetMapping(path="/")
    public @ResponseBody Iterable<StockHistorical> getStockHistorical() {
        return stockHistoricalService.getStockHistorical();
    }

    @PostMapping(path="/add")
    public String addNewStockHistorical (@RequestBody StockHistorical stockHistorical) {
        return stockHistoricalService.addNewStockHistorical(stockHistorical);
    }
}

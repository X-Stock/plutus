package com.xstock.plutus.v1.stockIntraday;


import com.xstock.plutus.exception.ApiRequestException;
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
        String result = stockIntradayService.addNewStockIntraday(stockIntraday);
        if (result == null) {
            throw new ApiRequestException("Failed to add new stock intraday data.");
        }
        return result;
    }
}

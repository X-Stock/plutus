package com.xstock.plutus.v1.stockIndex;

import com.xstock.plutus.exception.ApiRequestException;
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
        Iterable<StockIndex> stockIndices = stockIndexService.getAllByTicker(ticker);
        if (stockIndices == null) {
            throw new ApiRequestException("Failed to retrieve stock index data for ticker: " + ticker);
        }
        return stockIndices;
    }
}

package com.xstock.plutus.v1.stockHistorical;


import com.xstock.plutus.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class StockHistoricalController {
    @Autowired
    private StockHistoricalService stockHistoricalService;

    @GetMapping(path = "/stockHistorical")
    public Iterable<StockHistorical> getAllByTicker(@PathVariable String ticker) {
        Iterable<StockHistorical> stockHistorical = stockHistoricalService.getAllByTicker(ticker);
        if (stockHistorical == null) {
            throw new ApiRequestException("Failed to retrieve stock historical data for ticker: " + ticker);
        }
        return stockHistorical;
    }
}

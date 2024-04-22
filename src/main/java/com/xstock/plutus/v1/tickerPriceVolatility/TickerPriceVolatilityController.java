package com.xstock.plutus.v1.tickerPriceVolatility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class TickerPriceVolatilityController {
    @Autowired
    private TickerPriceVolatilityService tickerPriceVolatilityService;

    @GetMapping(path = "/tickerPriceVolatility")
    public Optional<TickerPriceVolatility> getByTicker(@PathVariable String ticker) {
        return tickerPriceVolatilityService.getByTicker(ticker);
    }
}

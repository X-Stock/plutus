package com.xstock.plutus.tickerPriceVolatility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/tickerPriceVolatility")
public class TickerPriceVolatilityController {
    @Autowired
    private TickerPriceVolatilityService tickerPriceVolatilityService;

    @GetMapping
    public Iterable<TickerPriceVolatility> getTickerPriceVolatility() {
        return tickerPriceVolatilityService.getTickerPriceVolatility();
    }

    @PostMapping(path = "/add")
    public String addNewTickerPriceVolatility(@RequestBody TickerPriceVolatility tickerPriceVolatility) {
        return tickerPriceVolatilityService.addNewTickerPriceVolatility(tickerPriceVolatility);
    }
}

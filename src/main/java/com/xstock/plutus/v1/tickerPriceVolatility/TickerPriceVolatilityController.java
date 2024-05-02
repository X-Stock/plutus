package com.xstock.plutus.v1.tickerPriceVolatility;

import com.xstock.plutus.utils.interfaces.controller.SingleResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class TickerPriceVolatilityController implements SingleResponseController<TickerPriceVolatility> {
    private final TickerPriceVolatilityService tickerPriceVolatilityService;

    @Override
    @GetMapping(path = "/tickerPriceVolatility")
    public TickerPriceVolatility getByTicker(@PathVariable String ticker) {
        return tickerPriceVolatilityService.getByTicker(ticker);
    }
}

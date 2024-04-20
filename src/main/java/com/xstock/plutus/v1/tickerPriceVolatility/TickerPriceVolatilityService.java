package com.xstock.plutus.v1.tickerPriceVolatility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TickerPriceVolatilityService {
    @Autowired
    private TickerPriceVolatilityRepository tickerPriceVolatilityRepository;

    public Iterable<TickerPriceVolatility> getTickerPriceVolatility() {
        return tickerPriceVolatilityRepository.findAll();
    }

    public String addNewTickerPriceVolatility(TickerPriceVolatility tickerPriceVolatility) {
        tickerPriceVolatilityRepository.save(tickerPriceVolatility);
        return "Saved TickerPriceVolatility";
    }
}

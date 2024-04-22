package com.xstock.plutus.v1.tickerPriceVolatility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TickerPriceVolatilityService {
    @Autowired
    private TickerPriceVolatilityRepository tickerPriceVolatilityRepository;

    public Iterable<TickerPriceVolatility> getAll() {
        return tickerPriceVolatilityRepository.findAll();
    }

    public Optional<TickerPriceVolatility> getByTicker(String ticker) {
        return tickerPriceVolatilityRepository.findByCompany_Ticker(ticker);
    }
}

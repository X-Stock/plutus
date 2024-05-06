package com.xstock.plutus.v1.tickerPriceVolatility;

import com.xstock.plutus.exception.EntityNotFoundException;
import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TickerPriceVolatilityService implements SingleResponseService<TickerPriceVolatility> {
    private final TickerPriceVolatilityRepository tickerPriceVolatilityRepository;

    @Override
    public TickerPriceVolatility getByTicker(String ticker) {
        Optional<TickerPriceVolatility> tickerPriceVolatility = tickerPriceVolatilityRepository.findByCompany_Ticker(ticker);
        return tickerPriceVolatility.orElseThrow(() -> new EntityNotFoundException("ticker price volatility by " + ticker));
    }

    @Override
    public Iterable<TickerPriceVolatility> getAll() {
        Iterable<TickerPriceVolatility> tickerPriceVolatilises = tickerPriceVolatilityRepository.findAll();
        if (!tickerPriceVolatilises.iterator().hasNext()) {
            throw new EntityNotFoundException("all ticker price volatilises");
        }
        return tickerPriceVolatilises;
    }
}

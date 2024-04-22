package com.xstock.plutus.v1.stockHistorical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockHistoricalService {
    @Autowired
    private StockHistoricalRepository stockHistoricalRepository;

    public Iterable<StockHistorical> getAll() {
        return stockHistoricalRepository.findAll();
    }

    public Iterable<StockHistorical> getAllByTicker(String ticker) {
        return stockHistoricalRepository.findAllByCompany_Ticker(ticker);
    }
}

package com.xstock.plutus.v1.stockIndex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockIndexService {
    @Autowired
    private StockIndexRepository stockIndexRepository;

    public Iterable<StockIndex> getAll() {
        return stockIndexRepository.findAll();
    }

    public Iterable<StockIndex> getAllByTicker(String ticker) {
        return stockIndexRepository.findAllByCompanies_Ticker(ticker);
    }
}

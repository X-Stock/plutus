package com.xstock.plutus.v1.stockIndex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockIndexService {
    @Autowired
    private StockIndexRepository stockIndexRepository;

    public Iterable<StockIndex> getStockIndices() {
        return stockIndexRepository.findAll();
    }

    public String addNewStockIndex(StockIndex stockIndex) {
        stockIndexRepository.save(stockIndex);
        return "Saved stock index";
    }
}

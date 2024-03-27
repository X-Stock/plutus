package com.xstock.plutus.stockHistorical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockHistoricalService {
    @Autowired
    private StockHistoricalRepository stockHistoricalRepository;

    public Iterable<StockHistorical> getStockHistorical() {
        return stockHistoricalRepository.findAll();
    }

    public String addNewStockHistorical(StockHistorical stockHistorical) {
        stockHistoricalRepository.save(stockHistorical);
        return "Saved stock historical data";
    }
}

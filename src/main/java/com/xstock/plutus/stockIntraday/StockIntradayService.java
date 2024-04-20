package com.xstock.plutus.stockIntraday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockIntradayService {
    @Autowired
    private StockIntradayRepository stockIntradayRepository;

    public Iterable<StockIntraday> getStockIntraday() {
        return stockIntradayRepository.findAll();
    }

    public String addNewStockIntraday(StockIntraday stockIntraday) {
        stockIntradayRepository.save(stockIntraday);
        return "Saved intraday data";
    }
}

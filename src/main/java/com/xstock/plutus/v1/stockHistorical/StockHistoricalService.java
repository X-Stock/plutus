package com.xstock.plutus.v1.stockHistorical;

import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockHistoricalService implements MultiResponseService<StockHistorical> {
    private final StockHistoricalRepository stockHistoricalRepository;

    @Override
    public Iterable<StockHistorical> getAllByTicker(String ticker) {
        return stockHistoricalRepository.findAllByCompany_Ticker(ticker);
    }

    @Override
    public Iterable<StockHistorical> getAll() {
        return stockHistoricalRepository.findAll();
    }
}

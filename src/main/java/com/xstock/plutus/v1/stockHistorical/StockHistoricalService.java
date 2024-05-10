package com.xstock.plutus.v1.stockHistorical;

import com.xstock.plutus.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockHistoricalService implements MultiResponseService<StockHistorical> {
    private final StockHistoricalRepository stockHistoricalRepository;

    @Override
    public Iterable<StockHistorical> getAllByTicker(String ticker) {
        Iterable<StockHistorical> stockHistorical = stockHistoricalRepository.findAllByCompany_Ticker(ticker);
        if (!stockHistorical.iterator().hasNext()) {
            throw new ResourceNotFoundException("stock historical by " + ticker);
        }
        return stockHistorical;
    }

    @Override
    public Iterable<StockHistorical> getAll() {
        Iterable<StockHistorical> stockHistorical = stockHistoricalRepository.findAll();
        if (!stockHistorical.iterator().hasNext()) {
            throw new ResourceNotFoundException("all stock historical");
        }
        return stockHistorical;
    }
}

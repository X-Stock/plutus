package com.xstock.plutus.v1.stockIndex;

import com.xstock.plutus.exception.EntityNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockIndexService implements MultiResponseService<StockIndex> {
    private final StockIndexRepository stockIndexRepository;

    @Override
    public Iterable<StockIndex> getAllByTicker(String ticker) {
        Iterable<StockIndex> stockIndices = stockIndexRepository.findAllByCompanies_Ticker(ticker);
        if (!stockIndices.iterator().hasNext()) {
            throw new EntityNotFoundException("stock indices by " + ticker);
        }
        return stockIndices;
    }

    @Override
    public Iterable<StockIndex> getAll() {
        Iterable<StockIndex> stockIndices = stockIndexRepository.findAll();
        if (!stockIndices.iterator().hasNext()) {
            throw new EntityNotFoundException("all stock indices");
        }
        return stockIndices;
    }
}

package com.xstock.plutus.v1.stockIndex;

import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockIndexService implements MultiResponseService<StockIndex> {
    private final StockIndexRepository stockIndexRepository;

    @Override
    public Iterable<StockIndex> getAllByTicker(String ticker) {
        return stockIndexRepository.findAllByCompany_Ticker(ticker);
    }

    @Override
    public Iterable<StockIndex> getAll() {
        return stockIndexRepository.findAll();
    }
}

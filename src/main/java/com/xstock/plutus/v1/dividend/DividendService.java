package com.xstock.plutus.v1.dividend;

import com.xstock.plutus.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DividendService implements MultiResponseService<Dividend> {
    private final DividendRepository dividendRepository;

    @Override
    public Iterable<Dividend> getAllByTicker(String ticker) {
        Iterable<Dividend> dividends = dividendRepository.findAllByCompany_Ticker(ticker);
        if (!dividends.iterator().hasNext()) {
            throw new ResourceNotFoundException("dividends by " + ticker);
        }
        return dividends;
    }

    @Override
    public Iterable<Dividend> getAll() {
        Iterable<Dividend> dividends = dividendRepository.findAll();
        if (!dividends.iterator().hasNext()) {
            throw new ResourceNotFoundException("all dividends");
        }
        return dividends;
    }
}
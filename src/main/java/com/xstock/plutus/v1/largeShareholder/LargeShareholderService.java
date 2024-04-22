package com.xstock.plutus.v1.largeShareholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LargeShareholderService {
    @Autowired
    private LargeShareholderRepository largeShareholderRepository;

    public Iterable<LargeShareholder> getAll() {
        return largeShareholderRepository.findAll();
    }

    public Iterable<LargeShareholder> getAllFromTicker(String ticker) {
        return largeShareholderRepository.findAllByCompany_Ticker(ticker);
    }
}

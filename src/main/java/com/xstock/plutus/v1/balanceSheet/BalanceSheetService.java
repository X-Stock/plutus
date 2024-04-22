package com.xstock.plutus.v1.balanceSheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BalanceSheetService {
    @Autowired
    private BalanceSheetRepository balanceSheetRepository;

    public Iterable<BalanceSheet> getAll() {
        return balanceSheetRepository.findAll();
    }

    public Optional<BalanceSheet> getByTicker(String ticker) {
        return balanceSheetRepository.findByCompany_Ticker(ticker);
    }
}

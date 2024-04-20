package com.xstock.plutus.v1.balanceSheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BalanceSheetService {
    @Autowired
    private BalanceSheetRepository balanceSheetRepository;

    public Iterable<BalanceSheet> getBalanceSheets() {
        return balanceSheetRepository.findAll();
    }

    public String addNewBalanceSheet(@RequestBody BalanceSheet balanceSheet) {
        balanceSheetRepository.save(balanceSheet);
        return "Saved balance sheet";

    }
}

package com.xstock.plutus.balance_sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class BalanceSheetService {
    @Autowired
    private BalanceSheetRepository balanceSheetRepository;

    public Iterable<BalanceSheet> getBalanceSheet() {return balanceSheetRepository.findAll();}

    public String addBalanceSheet (@RequestBody BalanceSheet balanceSheet) {
        balanceSheetRepository.save(balanceSheet);
        return "Saved balance sheet";

    }
}

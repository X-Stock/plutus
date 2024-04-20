package com.xstock.plutus.v1.balanceSheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/balanceSheets")
public class BalanceSheetController {
    @Autowired
    private BalanceSheetService balanceSheetService;

    @GetMapping
    public Iterable<BalanceSheet> getBalanceSheets() {
        return balanceSheetService.getBalanceSheets();
    }

    @PostMapping(path = "/add")
    public String addNewBalanceSheet(@RequestBody BalanceSheet balanceSheet) {
        return balanceSheetService.addNewBalanceSheet(balanceSheet);
    }
}

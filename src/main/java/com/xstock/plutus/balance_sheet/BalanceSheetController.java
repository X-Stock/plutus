package com.xstock.plutus.balance_sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path="/api/v1/balanceSheet")
public class BalanceSheetController {
    @Autowired
    private BalanceSheetService balanceSheetService;

    @GetMapping(path="/")
    public Iterable<BalanceSheet> getBalanceSheet() {return balanceSheetService.getBalanceSheet();}

    @PostMapping(path="/")
    public  String addBalanceSheet (@RequestBody BalanceSheet balanceSheet) {return balanceSheetService.addBalanceSheet(balanceSheet);}
}

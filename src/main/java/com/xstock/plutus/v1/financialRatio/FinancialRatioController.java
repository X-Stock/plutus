package com.xstock.plutus.v1.financialRatio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/financialRatio")
public class FinancialRatioController {
    @Autowired
    private FinancialRatioService financialRatioService;

    @GetMapping
    public Iterable<FinancialRatio> getFinancialRatios() {
        return financialRatioService.getFinancialRatios();
    }

    @PostMapping(path = "/add")
    public String addNewFinancialRatio(@RequestBody FinancialRatio financialRatio) {
        return financialRatioService.addNewFinancialRatio(financialRatio);
    }
}

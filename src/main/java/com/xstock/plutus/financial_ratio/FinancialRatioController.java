package com.xstock.plutus.financial_ratio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path="/api/v1/financialRatio")
public class FinancialRatioController {
    @Autowired
    private FinancialRatioService financialRatioService;

    @GetMapping(path = "/")
    public Iterable<FinancialRatio> getFinancialRatio() {return financialRatioService.getFinancialRatio();}

    @PostMapping(path = "/")
    public String addFinancialRatio (@RequestBody FinancialRatio financialRatio) {return financialRatioService.addFinancialRatio(financialRatio);}
}

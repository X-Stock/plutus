package com.xstock.plutus.v1.financialRatio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class FinancialRatioController {
    @Autowired
    private FinancialRatioService financialRatioService;

    @GetMapping(path = "/financialRatio")
    public Optional<FinancialRatio> getByTicker(@PathVariable String ticker) {
        return financialRatioService.getByTicker(ticker);
    }
}

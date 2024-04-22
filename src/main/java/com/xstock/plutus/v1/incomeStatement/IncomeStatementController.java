package com.xstock.plutus.v1.incomeStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class IncomeStatementController {
    @Autowired
    private IncomeStatementService incomeStatementService;

    @GetMapping(path = "/incomeStatement")
    public Optional<IncomeStatement> getByTicker(@PathVariable String ticker) {
        return incomeStatementService.getByTicker(ticker);
    }
}

package com.xstock.plutus.v1.incomeStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/incomeStatements")
public class IncomeStatementController {
    @Autowired
    private IncomeStatementService incomeStatementService;

    @GetMapping
    public Iterable<IncomeStatement> getIncomeStatements() {
        return incomeStatementService.getIncomeStatements();
    }

    @PostMapping(path = "/add")
    public String addNewIncomeStatement(@RequestBody IncomeStatement incomeStatement) {
        return incomeStatementService.addNewIncomeStatement(incomeStatement);
    }
}

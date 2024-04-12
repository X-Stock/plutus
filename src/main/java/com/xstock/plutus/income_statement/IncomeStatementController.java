package com.xstock.plutus.income_statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path="/api/v1/incomeStatements")
public class IncomeStatementController {
    @Autowired
    private IncomeStatementService incomeStatementService;

    @GetMapping(path="/")
    public Iterable<IncomeStatement> getIncomeStatement() {return incomeStatementService.getIncomeStatement();}

    @PostMapping(path="/")
    public String addIncomeStatement (@RequestBody IncomeStatement incomeStatement) {
        return incomeStatementService.addIncomeStatement(incomeStatement);
    }
}

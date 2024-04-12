package com.xstock.plutus.income_statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service

public class IncomeStatementService {
    @Autowired
    private IncomeStatementRepository incomeStatementRepository;

    public Iterable<IncomeStatement> getIncomeStatement() {return incomeStatementRepository.findAll();}

    public String addIncomeStatement (@RequestBody IncomeStatement incomeStatement) {
        incomeStatementRepository.save(incomeStatement);
        return "Saved Income Statement";
    }
}

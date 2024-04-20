package com.xstock.plutus.incomeStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service

public class IncomeStatementService {
    @Autowired
    private IncomeStatementRepository incomeStatementRepository;

    public Iterable<IncomeStatement> getIncomeStatements() {
        return incomeStatementRepository.findAll();
    }

    public String addNewIncomeStatement(@RequestBody IncomeStatement incomeStatement) {
        incomeStatementRepository.save(incomeStatement);
        return "Saved Income Statement";
    }
}

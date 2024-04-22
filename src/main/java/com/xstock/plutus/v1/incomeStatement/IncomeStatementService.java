package com.xstock.plutus.v1.incomeStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class IncomeStatementService {
    @Autowired
    private IncomeStatementRepository incomeStatementRepository;

    public Iterable<IncomeStatement> getAll() {
        return incomeStatementRepository.findAll();
    }

    public Optional<IncomeStatement> getByTicker(String ticker) {
        return incomeStatementRepository.findByCompany_Ticker(ticker);
    }
}

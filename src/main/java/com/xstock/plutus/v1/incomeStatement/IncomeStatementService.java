package com.xstock.plutus.v1.incomeStatement;

import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IncomeStatementService implements SingleResponseService<IncomeStatement> {
    private final IncomeStatementRepository incomeStatementRepository;

    @Override
    public IncomeStatement getByTicker(String ticker) {
        Optional<IncomeStatement> incomeStatement = incomeStatementRepository.findByCompany_Ticker(ticker);
        return incomeStatement.orElseThrow();
    }

    @Override
    public Iterable<IncomeStatement> getAll() {
        return incomeStatementRepository.findAll();
    }
}

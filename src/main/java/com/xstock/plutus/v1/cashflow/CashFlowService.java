package com.xstock.plutus.v1.cashflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CashFlowService {
    @Autowired
    private CashFlowRepository cashFlowRepository;

    public Iterable<CashFlow> getAll() {
        return cashFlowRepository.findAll();
    }

    public Optional<CashFlow> getByTicker(String ticker) {
        return cashFlowRepository.findByCompany_Ticker(ticker);
    }
}

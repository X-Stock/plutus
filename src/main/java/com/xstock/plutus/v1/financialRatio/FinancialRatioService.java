package com.xstock.plutus.v1.financialRatio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinancialRatioService {
    @Autowired
    private FinancialRatioRepository financialRatioRepository;

    public Iterable<FinancialRatio> getAll() {
        return financialRatioRepository.findAll();
    }

    public Optional<FinancialRatio> getByTicker(String ticker) {
        return financialRatioRepository.findByCompany_Ticker(ticker);
    }

}

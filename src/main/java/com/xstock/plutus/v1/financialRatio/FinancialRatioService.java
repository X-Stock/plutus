package com.xstock.plutus.v1.financialRatio;

import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FinancialRatioService implements SingleResponseService<FinancialRatio> {
    private final FinancialRatioRepository financialRatioRepository;

    @Override
    public FinancialRatio getByTicker(String ticker) {
        Optional<FinancialRatio> financialRatio = financialRatioRepository.findByCompany_Ticker(ticker);
        return financialRatio.orElseThrow();
    }

    @Override
    public Iterable<FinancialRatio> getAll() {
        return financialRatioRepository.findAll();
    }
}

package com.xstock.plutus.financialRatio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FinancialRatioService {
    @Autowired
    private FinancialRatioRepository financialRatioRepository;

    public Iterable<FinancialRatio> getFinancialRatios() {
        return financialRatioRepository.findAll();
    }

    public String addNewFinancialRatio(@RequestBody FinancialRatio financialRatio) {
        financialRatioRepository.save(financialRatio);
        return "Saved financial ratio";
    }

}

package com.xstock.plutus.financial_ratio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class FinancialRatioService {
    @Autowired
    private FinancialRatioRepository financialRatioRepository;

    public Iterable<FinancialRatio> getFinancialRatio() {return financialRatioRepository.findAll();}

    public String addFinancialRatio (@RequestBody FinancialRatio financialRatio) {
        financialRatioRepository.save(financialRatio);
        return "Saved financial ratio";
    }

}

package com.xstock.plutus.cashflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CashFlowService {
    @Autowired
    private CashFlowRepository cashFlowRepository;

    public Iterable<CashFlow> getCashFlow() {return cashFlowRepository.findAll();}

    public String addCashFlow (@RequestBody CashFlow cashFlow) {
        cashFlowRepository.save(cashFlow);
        return "Saved cash flow";
    }

}

package com.xstock.plutus.v1.cashflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/cashFlow")
public class CashFlowController {
    @Autowired
    private CashFlowService cashFlowService;

    @GetMapping
    public Iterable<CashFlow> getCashFlows() {
        return cashFlowService.getCashFlows();
    }

    @PostMapping(path = "/add")
    public String addNewCashFlow(@RequestBody CashFlow cashFlow) {
        return cashFlowService.addNewCashFlow(cashFlow);
    }
}

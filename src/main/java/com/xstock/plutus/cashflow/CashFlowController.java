package com.xstock.plutus.cashflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path="/api/v1/cashFlow")
public class CashFlowController {
    @Autowired
    private CashFlowService cashFlowService;

    @GetMapping(path="/")
    public Iterable<CashFlow> getCashFlow() {return cashFlowService.getCashFlow();}

    @PostMapping(path="/")
    public String addCashFlow (@RequestBody CashFlow cashFlow) {
        return cashFlowService.addCashFlow(cashFlow);
    }
}

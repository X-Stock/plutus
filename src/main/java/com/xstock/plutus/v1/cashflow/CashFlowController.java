package com.xstock.plutus.v1.cashflow;

import com.xstock.plutus.utils.interfaces.controller.SingleResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class CashFlowController implements SingleResponseController<CashFlow> {
    private final CashFlowService cashFlowService;

    @Override
    @GetMapping(path = "/cashFlow")
    public CashFlow getByTicker(@PathVariable String ticker) {
        return cashFlowService.getByTicker(ticker);
    }
}

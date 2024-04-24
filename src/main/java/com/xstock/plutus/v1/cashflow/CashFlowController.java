package com.xstock.plutus.v1.cashflow;

import com.xstock.plutus.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class CashFlowController {
    @Autowired
    private CashFlowService cashFlowService;

    @GetMapping(path = "/cashFlow")
    public Optional<CashFlow> getByTicker(@PathVariable String ticker) {
        Optional<CashFlow> cashFlow = cashFlowService.getByTicker(ticker);
        if (!cashFlow.isPresent()) {
            throw new ApiRequestException("Failed to retrieve cash flow for ticker: " + ticker);
        }
        return cashFlow;
    }
}

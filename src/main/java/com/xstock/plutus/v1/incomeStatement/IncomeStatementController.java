package com.xstock.plutus.v1.incomeStatement;

import com.xstock.plutus.utils.interfaces.controller.SingleResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class IncomeStatementController implements SingleResponseController<IncomeStatement> {
    private final IncomeStatementService incomeStatementService;

    @Override
    @GetMapping(path = "/incomeStatement")
    public IncomeStatement getByTicker(@PathVariable String ticker) {
        return incomeStatementService.getByTicker(ticker);
    }
}

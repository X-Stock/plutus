package com.xstock.plutus.v1.financialRatio;

import com.xstock.plutus.utils.interfaces.controller.SingleResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class FinancialRatioController implements SingleResponseController<FinancialRatio> {
    private final FinancialRatioService financialRatioService;

    @Override
    @GetMapping(path = "/financialRatio")
    public FinancialRatio getByTicker(@PathVariable String ticker) {
        return financialRatioService.getByTicker(ticker);
    }
}

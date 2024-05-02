package com.xstock.plutus.v1.balanceSheet;

import com.xstock.plutus.utils.interfaces.controller.SingleResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class BalanceSheetController implements SingleResponseController<BalanceSheet> {
    private final BalanceSheetService balanceSheetService;

    @Override
    @GetMapping(path = "/balanceSheet")
    public BalanceSheet getByTicker(@PathVariable String ticker) {
        return balanceSheetService.getByTicker(ticker);
    }
}

package com.xstock.plutus.v1.balanceSheet;

import com.xstock.plutus.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class BalanceSheetController {
    @Autowired
    private BalanceSheetService balanceSheetService;

    @GetMapping(path = "/balanceSheet")
    public Optional<BalanceSheet> getByTicker(@PathVariable String ticker) {
        Optional<BalanceSheet> balanceSheet = balanceSheetService.getByTicker(ticker);
        if (!balanceSheet.isPresent()) {
            throw new ApiRequestException("Failed to retrieve balance sheet for ticker: " + ticker);
        }
        return balanceSheet;
    }
}

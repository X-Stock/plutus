package com.xstock.plutus.v1.balanceSheet;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class BalanceSheetController implements CommonController<BalanceSheet> {
    private final BalanceSheetService balanceSheetService;

    @Override
    @GetMapping(path = "/balanceSheets")
    public PaginatedResponse<BalanceSheet> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return balanceSheetService.getAllByTicker(ticker, pageable);
    }
}

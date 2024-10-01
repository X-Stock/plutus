package com.xstock.plutus.api.v1.incomeStatement;

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
public class IncomeStatementController implements CommonController<IncomeStatement> {
    private final IncomeStatementService incomeStatementService;

    @Override
    @GetMapping(path = "/incomeStatement")
    public PaginatedResponse<IncomeStatement> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return incomeStatementService.getAllByTicker(ticker, pageable);
    }
}

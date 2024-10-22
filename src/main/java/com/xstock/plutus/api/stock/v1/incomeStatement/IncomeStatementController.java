package com.xstock.plutus.api.stock.v1.incomeStatement;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class IncomeStatementController implements CommonController<IncomeStatement> {
    private final IncomeStatementService incomeStatementService;

    @Override
    @GetMapping(path = "/incomeStatement")
    public PaginatedResponse<IncomeStatement> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return incomeStatementService.getAllByTicker(ticker, pageable, unpaged);
    }
}

package com.xstock.plutus.api.stock.v1.dividend;

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
public class DividendController implements CommonController<Dividend> {
    private final DividendService dividendService;

    @Override
    @GetMapping(path = "/dividends")
    public PaginatedResponse<Dividend> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return dividendService.getAllByTicker(ticker, pageable, unpaged);
    }
}

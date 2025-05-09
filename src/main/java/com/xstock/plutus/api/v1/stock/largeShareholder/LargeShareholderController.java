package com.xstock.plutus.api.v1.stock.largeShareholder;

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
public class LargeShareholderController implements CommonController<LargeShareholder> {
    private final LargeShareholderService largeShareholderService;

    @Override
    @GetMapping(path = "/shareholders")
    public PaginatedResponse<LargeShareholder> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return largeShareholderService.getAllByTicker(ticker, pageable, unpaged);
    }
}

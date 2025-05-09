package com.xstock.plutus.api.v1.stock.insiderDeal;

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
public class InsiderDealController implements CommonController<InsiderDeal> {
    private final InsiderDealService insiderDealService;

    @Override
    @GetMapping(path = "/insider-deals")
    public PaginatedResponse<InsiderDeal> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return insiderDealService.getAllByTicker(ticker, pageable, unpaged);
    }
}

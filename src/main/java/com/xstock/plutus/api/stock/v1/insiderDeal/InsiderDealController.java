package com.xstock.plutus.api.stock.v1.insiderDeal;

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
public class InsiderDealController implements CommonController<InsiderDeal> {
    private final InsiderDealService insiderDealService;

    @Override
    @GetMapping(path = "/insiderDeals")
    public PaginatedResponse<InsiderDeal> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return insiderDealService.getAllByTicker(ticker, pageable);
    }
}

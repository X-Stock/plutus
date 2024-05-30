package com.xstock.plutus.v1.insiderDeal;

import com.xstock.plutus.utils.interfaces.controller.MultiResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class InsiderDealController implements MultiResponseController<InsiderDeal> {
    private final InsiderDealService insiderDealService;

    @Override
    @GetMapping(path = "/insiderDeals")
    public Iterable<InsiderDeal> getAllByTicker(@PathVariable String ticker) {
        return insiderDealService.getAllByTicker(ticker);
    }
}

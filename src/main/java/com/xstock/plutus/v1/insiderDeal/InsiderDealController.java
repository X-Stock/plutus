package com.xstock.plutus.v1.insiderDeal;

import com.xstock.plutus.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class InsiderDealController {
    @Autowired
    private InsiderDealService insiderDealService;

    @GetMapping(path = "/insiderDeals")
    public Iterable<InsiderDeal> getAllByTicker(@PathVariable String ticker) {
        Iterable<InsiderDeal> insiderDeals = insiderDealService.getAllByTicker(ticker);
        if (insiderDeals == null) {
            throw new ApiRequestException("Failed to retrieve insider deals for ticker: " + ticker);
        }
        return insiderDeals;
    }
}

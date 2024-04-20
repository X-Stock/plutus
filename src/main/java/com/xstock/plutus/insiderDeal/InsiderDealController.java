package com.xstock.plutus.insiderDeal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/insiderDeals")
public class InsiderDealController {
    @Autowired
    private InsiderDealService insiderDealService;

    @GetMapping
    public Iterable<InsiderDeal> getInsiderDeals() {
        return insiderDealService.getInsiderDeals();
    }

    @PostMapping(path = "/add")
    public String addNewInsiderDeal(@RequestBody InsiderDeal insiderDeal) {
        return insiderDealService.addNewInsiderDeal(insiderDeal);
    }
}

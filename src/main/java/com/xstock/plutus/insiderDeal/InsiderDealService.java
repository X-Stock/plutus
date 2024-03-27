package com.xstock.plutus.insiderDeal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InsiderDealService {
    @Autowired
    private InsiderDealRepository insiderDealRepository;

    public Iterable<InsiderDeal> getInsiderDeals() {
        return insiderDealRepository.findAll();
    }

    public String addNewInsiderDeal (@RequestBody InsiderDeal insiderDeal) {
        insiderDealRepository.save(insiderDeal);
        return "Saved insider deal";
    }
}

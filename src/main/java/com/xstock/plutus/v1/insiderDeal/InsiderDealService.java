package com.xstock.plutus.v1.insiderDeal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsiderDealService {
    @Autowired
    private InsiderDealRepository insiderDealRepository;

    public Iterable<InsiderDeal> getAll() {
        return insiderDealRepository.findAll();
    }

    public Iterable<InsiderDeal> getAllByTicker(String ticker) {
        return insiderDealRepository.findAllByCompany_Ticker(ticker);
    }
}

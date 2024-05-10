package com.xstock.plutus.v1.insiderDeal;

import com.xstock.plutus.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InsiderDealService implements MultiResponseService<InsiderDeal> {
    private final InsiderDealRepository insiderDealRepository;

    @Override
    public Iterable<InsiderDeal> getAllByTicker(String ticker) {
        Iterable<InsiderDeal> insiderDeals = insiderDealRepository.findAllByCompany_Ticker(ticker);
        if (!insiderDeals.iterator().hasNext()) {
            throw new ResourceNotFoundException("insider deals by " + ticker);
        }
        return insiderDeals;
    }

    @Override
    public Iterable<InsiderDeal> getAll() {
        Iterable<InsiderDeal> insiderDeals = insiderDealRepository.findAll();
        if (!insiderDeals.iterator().hasNext()) {
            throw new ResourceNotFoundException("all insider deals");
        }
        return insiderDeals;
    }
}

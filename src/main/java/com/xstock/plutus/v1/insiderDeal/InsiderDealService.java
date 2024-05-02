package com.xstock.plutus.v1.insiderDeal;

import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InsiderDealService implements MultiResponseService<InsiderDeal> {
    private final InsiderDealRepository insiderDealRepository;

    @Override
    public Iterable<InsiderDeal> getAllByTicker(String ticker) {
        return insiderDealRepository.findAllByCompany_Ticker(ticker);
    }

    @Override
    public Iterable<InsiderDeal> getAll() {
        return insiderDealRepository.findAll();
    }
}

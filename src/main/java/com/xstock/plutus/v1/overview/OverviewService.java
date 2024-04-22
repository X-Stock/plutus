package com.xstock.plutus.v1.overview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OverviewService {
    @Autowired
    private OverviewRepository overviewRepository;

    public Iterable<Overview> getAll() {
        return overviewRepository.findAll();
    }

    public Optional<Overview> getByTicker(String ticker) {
        return overviewRepository.findByCompany_Ticker(ticker);
    }
}

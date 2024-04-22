package com.xstock.plutus.v1.fundamentalRatio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FundamentalRatioService {
    @Autowired
    private FundamentalRatioRepository fundamentalRatioRepository;

    public Iterable<FundamentalRatio> getAll() {
        return fundamentalRatioRepository.findAll();
    }

    public Optional<FundamentalRatio> getByTicker(String ticker) {
        return fundamentalRatioRepository.findByCompany_Ticker(ticker);
    }
}

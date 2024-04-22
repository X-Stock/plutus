package com.xstock.plutus.v1.subsidiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubsidiaryService {
    @Autowired
    private SubsidiaryRepository subsidiaryRepository;

    public Iterable<Subsidiary> getAll() {
        return subsidiaryRepository.findAll();
    }

    public Iterable<Subsidiary> getAllByTicker(String ticker) {
        return subsidiaryRepository.findAllByCompany_Ticker(ticker);
    }
}

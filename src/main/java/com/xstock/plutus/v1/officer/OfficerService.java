package com.xstock.plutus.v1.officer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerService {
    @Autowired
    private OfficerRepository officerRepository;

    public Iterable<Officer> getAll() {
        return officerRepository.findAll();
    }

    public Iterable<Officer> getAllByTicker(String ticker) {
        return officerRepository.findAllByCompany_Ticker(ticker);
    }
}

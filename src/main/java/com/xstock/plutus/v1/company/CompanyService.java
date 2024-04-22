package com.xstock.plutus.v1.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService{
    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Company> getAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> getByTicker(String ticker) {
        return companyRepository.findByTicker(ticker);
    }
}

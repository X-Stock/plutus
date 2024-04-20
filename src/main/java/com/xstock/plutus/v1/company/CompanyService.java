package com.xstock.plutus.v1.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public String addNewCompany(Company company) {
        companyRepository.save(company);
        return "Saved company";
    }
}

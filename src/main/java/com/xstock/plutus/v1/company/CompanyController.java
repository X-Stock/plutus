package com.xstock.plutus.v1.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public Iterable<Company> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/{ticker}")
    public Optional<Company> getByTicker(@PathVariable String ticker) {
        return companyService.getByTicker(ticker);
    }
}

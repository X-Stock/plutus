package com.xstock.plutus.v1.company;

import com.xstock.plutus.exception.ApiRequestException;
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
        Iterable<Company> companies = companyService.getAll();
        if (companies == null) {
            throw new ApiRequestException("Failed to retrieve companies from the database");
        }
        return companies;
    }

    @GetMapping("/{ticker}")
    public Optional<Company> getByTicker(@PathVariable String ticker) {
        return companyService.getByTicker(ticker);
    }
}

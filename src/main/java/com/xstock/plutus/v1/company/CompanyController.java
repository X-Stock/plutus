package com.xstock.plutus.v1.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public Iterable<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public String addNewCompany(@RequestBody Company company) {
        return companyService.addNewCompany(company);
    }
}

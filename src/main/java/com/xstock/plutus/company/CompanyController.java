package com.xstock.plutus.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping(path="/")
    public Iterable<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public String addNewCompany (@RequestBody Company company) {
        return companyService.addNewCompany(company);
    }
}

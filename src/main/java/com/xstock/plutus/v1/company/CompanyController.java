package com.xstock.plutus.v1.company;

import com.xstock.plutus.utils.interfaces.controller.SingleResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies")
public class CompanyController implements SingleResponseController<Company> {
    private final CompanyService companyService;

    @Override
    @GetMapping("/{ticker}")
    public Company getByTicker(@PathVariable String ticker) {
        return companyService.getByTicker(ticker);
    }

    @GetMapping
    public Iterable<Company> getAll() {
        return companyService.getAll();
    }
}

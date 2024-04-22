package com.xstock.plutus.v1.subsidiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class SubsidiaryController {
    @Autowired
    private SubsidiaryService subsidiaryService;

    @GetMapping(path = "/subsidiaries")
    public Iterable<Subsidiary> getAllByTicker(@PathVariable String ticker) {
        return subsidiaryService.getAllByTicker(ticker);
    }
}

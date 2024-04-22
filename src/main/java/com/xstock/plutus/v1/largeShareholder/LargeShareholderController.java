package com.xstock.plutus.v1.largeShareholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class LargeShareholderController {
    @Autowired
    private LargeShareholderService largeShareholderService;

    @GetMapping(path = "/shareHolders")
    public Iterable<LargeShareholder> getAll() {
        return largeShareholderService.getAll();
    }

    @GetMapping(path = "/companies/{ticker}/shareHolders")
    public Iterable<LargeShareholder> getAllByTicker(@PathVariable String ticker) {
        return largeShareholderService.getAllFromTicker(ticker);
    }
}

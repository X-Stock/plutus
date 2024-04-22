package com.xstock.plutus.v1.overview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class OverviewController {
    @Autowired
    private OverviewService overviewService;

    @GetMapping(path = "/overview")
    public Optional<Overview> getByTicker(@PathVariable String ticker) {
        return overviewService.getByTicker(ticker);
    }
}

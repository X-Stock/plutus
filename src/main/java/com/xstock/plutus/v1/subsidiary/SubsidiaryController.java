package com.xstock.plutus.v1.subsidiary;

import com.xstock.plutus.exception.ApiRequestException;
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
        Iterable<Subsidiary> subsidiaries = subsidiaryService.getAllByTicker(ticker);
        if (subsidiaries == null) {
            throw new ApiRequestException("Failed to retrieve subsidiaries for ticker: " + ticker);
        }
        return subsidiaries;
    }
}

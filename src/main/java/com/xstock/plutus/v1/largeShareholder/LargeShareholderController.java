package com.xstock.plutus.v1.largeShareholder;

import com.xstock.plutus.exception.ApiRequestException;
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
        Iterable<LargeShareholder> largeShareholders = largeShareholderService.getAll();
        if (largeShareholders == null) {
            throw new ApiRequestException("Failed to retrieve all shareholders.");
        }
        return largeShareholders;
    }

    @GetMapping(path = "/companies/{ticker}/shareHolders")
    public Iterable<LargeShareholder> getAllByTicker(@PathVariable String ticker) {
        Iterable<LargeShareholder> largeShareholders = largeShareholderService.getAllFromTicker(ticker);
        if (largeShareholders == null) {
            throw new ApiRequestException("Failed to retrieve shareholders for ticker: " + ticker);
        }
        return largeShareholders;
    }
}

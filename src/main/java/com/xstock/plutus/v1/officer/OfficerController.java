package com.xstock.plutus.v1.officer;

import com.xstock.plutus.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class OfficerController {
    @Autowired
    private OfficerService officerService;

    @GetMapping(path = "/officers")
    public Iterable<Officer> getAllByTicker(@PathVariable String ticker) {
        Iterable<Officer> officers = officerService.getAllByTicker(ticker);
        if (officers == null) {
            throw new ApiRequestException("Failed to retrieve officers for ticker: " + ticker);
        }
        return officers;
    }
}

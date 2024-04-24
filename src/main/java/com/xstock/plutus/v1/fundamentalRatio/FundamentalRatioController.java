package com.xstock.plutus.v1.fundamentalRatio;

import com.xstock.plutus.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class FundamentalRatioController {
    @Autowired
    private FundamentalRatioService fundamentalRatioService;

    @GetMapping(path = "/fundamentalRatio")
    public Optional<FundamentalRatio> getByTicker(@PathVariable String ticker) {
        Optional<FundamentalRatio> fundamentalRatio = fundamentalRatioService.getByTicker(ticker);
        if (!fundamentalRatio.isPresent()) {
            throw new ApiRequestException("Failed to retrieve fundamental ratios for ticker: " + ticker);
        }
        return fundamentalRatio;
    }
}

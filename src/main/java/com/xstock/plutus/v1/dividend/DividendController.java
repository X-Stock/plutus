package com.xstock.plutus.v1.dividend;

import com.xstock.plutus.utils.interfaces.controller.MultiResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class DividendController implements MultiResponseController<Dividend> {
    private final DividendService dividendService;

    @Override
    @GetMapping(path = "/dividends")
    public Iterable<Dividend> getAllByTicker(String ticker) {
        return dividendService.getAllByTicker(ticker);
    }
}

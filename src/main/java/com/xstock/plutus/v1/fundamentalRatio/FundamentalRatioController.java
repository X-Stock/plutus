package com.xstock.plutus.v1.fundamentalRatio;

import com.xstock.plutus.utils.interfaces.controller.SingleResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class FundamentalRatioController implements SingleResponseController<FundamentalRatio> {
    private final FundamentalRatioService fundamentalRatioService;

    @Override
    @GetMapping(path = "/fundamentalRatio")
    public FundamentalRatio getByTicker(@PathVariable String ticker) {
        return fundamentalRatioService.getByTicker(ticker);
    }
}

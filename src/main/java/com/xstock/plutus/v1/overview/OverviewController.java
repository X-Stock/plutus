package com.xstock.plutus.v1.overview;

import com.xstock.plutus.utils.interfaces.controller.SingleResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class OverviewController implements SingleResponseController<Overview> {
    private final OverviewService overviewService;

    @Override
    @GetMapping(path = "/overview")
    public Overview getByTicker(@PathVariable String ticker) {
        return overviewService.getByTicker(ticker);
    }
}

package com.xstock.plutus.api.v1.stock.overview;

import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class OverviewController implements CommonController<Overview> {
    private final OverviewService overviewService;

    @Override
    @GetMapping(path = "/overview")
    public Overview getByTicker(String ticker) {
        return overviewService.getByTicker(ticker);
    }
}

package com.xstock.plutus.fundamentalRatio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/fundamentalRatio")
public class FundamentalRatioController {
    @Autowired
    private FundamentalRatioService fundamentalRatioService;

    @GetMapping
    public Iterable<FundamentalRatio> getFundamentalRatios() {
        return fundamentalRatioService.getFundamentalRatios();
    }

    @PostMapping(path = "/add")
    public String addNewFundamentalRatio(@RequestBody FundamentalRatio fundamentalRatio) {
        return fundamentalRatioService.addNewFundamentalRatio(fundamentalRatio);
    }
}

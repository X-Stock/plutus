package com.xstock.plutus.fundamental_ratio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path="/api/v1/fundamentalRatio")
public class FundamentalRatioController {
    @Autowired
    private FundamentalRatioService fundamentalRatioService;

    @GetMapping(path="/")
    public Iterable<FundamentalRatio> getFundamentalRatio() {return fundamentalRatioService.getFundamentalRatio();}

    @PostMapping(path="/")
    public String addFundamentalRatio (@RequestBody FundamentalRatio fundamentalRatio) {
        return fundamentalRatioService.addFundamentalRatio(fundamentalRatio);
    }
}

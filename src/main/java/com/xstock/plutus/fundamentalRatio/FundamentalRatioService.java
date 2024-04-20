package com.xstock.plutus.fundamentalRatio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FundamentalRatioService {
    @Autowired
    private FundamentalRatioRepository fundamentalRatioRepository;

    public Iterable<FundamentalRatio> getFundamentalRatios() {
        return fundamentalRatioRepository.findAll();
    }

    public String addNewFundamentalRatio(@RequestBody FundamentalRatio fundamentalRatio) {
        fundamentalRatioRepository.save(fundamentalRatio);
        return "Saved fundamental ratio";
    }
}

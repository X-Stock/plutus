package com.xstock.plutus.v1.subsidiary;

import com.xstock.plutus.utils.interfaces.controller.MultiResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class SubsidiaryController implements MultiResponseController<Subsidiary> {
    private final SubsidiaryService subsidiaryService;

    @Override
    @GetMapping(path = "/subsidiaries")
    public Iterable<Subsidiary> getAllByTicker(@PathVariable String ticker) {
        return subsidiaryService.getAllByTicker(ticker);
    }
}

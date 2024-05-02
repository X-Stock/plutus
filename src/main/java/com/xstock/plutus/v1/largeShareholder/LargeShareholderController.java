package com.xstock.plutus.v1.largeShareholder;

import com.xstock.plutus.utils.interfaces.controller.MultiResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class LargeShareholderController implements MultiResponseController<LargeShareholder> {
    private final LargeShareholderService largeShareholderService;

    @Override
    @GetMapping(path = "/companies/{ticker}/shareHolders")
    public Iterable<LargeShareholder> getAllByTicker(@PathVariable String ticker) {
        return largeShareholderService.getAllByTicker(ticker);
    }

    @GetMapping(path = "/shareHolders")
    public Iterable<LargeShareholder> getAll() {
        return largeShareholderService.getAll();
    }
}

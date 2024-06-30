package com.xstock.plutus.v1.largeShareholder;

import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class LargeShareholderController implements CommonController<LargeShareholder> {
    private final LargeShareholderService largeShareholderService;

    @Override
    @GetMapping(path = "/companies/{ticker}/shareHolders")
    public List<LargeShareholder> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return largeShareholderService.getAllByTicker(ticker, pageable);
    }
}

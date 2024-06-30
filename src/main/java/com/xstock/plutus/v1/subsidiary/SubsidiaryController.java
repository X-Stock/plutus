package com.xstock.plutus.v1.subsidiary;

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
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class SubsidiaryController implements CommonController<Subsidiary> {
    private final SubsidiaryService subsidiaryService;

    @Override
    @GetMapping(path = "/subsidiaries")
    public List<Subsidiary> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return subsidiaryService.getAllByTicker(ticker, pageable);
    }
}

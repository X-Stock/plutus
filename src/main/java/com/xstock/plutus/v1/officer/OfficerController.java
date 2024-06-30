package com.xstock.plutus.v1.officer;

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
public class OfficerController implements CommonController<Officer> {
    private final OfficerService officerService;

    @Override
    @GetMapping(path = "/officers")
    public List<Officer> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return officerService.getAllByTicker(ticker, pageable);
    }
}

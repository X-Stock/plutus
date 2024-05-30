package com.xstock.plutus.v1.officer;

import com.xstock.plutus.utils.interfaces.controller.MultiResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class OfficerController implements MultiResponseController<Officer> {
    private final OfficerService officerService;

    @Override
    @GetMapping(path = "/officers")
    public Iterable<Officer> getAllByTicker(@PathVariable String ticker) {
        return officerService.getAllByTicker(ticker);
    }
}

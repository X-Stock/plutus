package com.xstock.plutus.api.v1.stock.industry;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/industries")
@RestController
public class IndustryController {
    private final IndustryService industryService;

    @GetMapping
    public Map<String, Iterable<Industry>> geIndustryWithTickers() {
        Iterable<Industry> industries = industryService.geIndustryWithTickers();
        return Map.of("industries", industries);
    }
}

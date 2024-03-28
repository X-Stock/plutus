package com.xstock.plutus.overview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/overview")
public class OverviewController {
    @Autowired
    private OverviewService overviewService;

    @GetMapping(path="/")
    public Iterable<Overview> getOverview() {
        return overviewService.getOverviews();
    }
}

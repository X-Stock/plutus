package com.xstock.plutus.v1.overview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/overview")
public class OverviewController {
    @Autowired
    private OverviewService overviewService;

    @GetMapping
    public Iterable<Overview> getOverview() {
        return overviewService.getOverviews();
    }

    @PostMapping(path = "/add")
    public String addNewOverview(@RequestBody Overview overview) {
        return overviewService.addNewOverview(overview);
    }
}

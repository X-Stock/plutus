package com.xstock.plutus.subsidiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/subsidiaries")
public class SubsidiaryController {
    @Autowired
    private SubsidiaryService subsidiaryService;

    @GetMapping(path="/")
    public Iterable<Subsidiary> getSubsidiaries() {
        return subsidiaryService.getSubsidiaries();
    }

    @PostMapping(path="/add")
    public String addNewSubsidiary (@RequestBody Subsidiary subsidiary) {
        return subsidiaryService.addNewSubsidiary(subsidiary);
    }
}

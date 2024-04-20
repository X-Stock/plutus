package com.xstock.plutus.v1.officer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/officers")
public class OfficerController {
    @Autowired
    private OfficerService officerService;

    @GetMapping
    public Iterable<Officer> getOfficers() {
        return officerService.getOfficers();
    }

    @PostMapping(path = "/add")
    public String addNewOfficer(@RequestBody Officer officer) {
        return officerService.addNewOfficer(officer);
    }
}

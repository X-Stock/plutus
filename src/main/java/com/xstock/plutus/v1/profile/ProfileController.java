package com.xstock.plutus.v1.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public Iterable<Profile> getProfiles() {
        return profileService.getProfiles();
    }

    @PostMapping(path = "/add")
    public String addNewProfile(@RequestBody Profile profile) {
        return profileService.addNewProfile(profile);
    }
}

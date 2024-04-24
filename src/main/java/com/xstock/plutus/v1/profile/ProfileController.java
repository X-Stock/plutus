package com.xstock.plutus.v1.profile;

import com.xstock.plutus.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping(path = "/profile")
    public Optional<Profile> getByTicker(@PathVariable String ticker) {
        Optional<Profile> profile = profileService.getByTicker(ticker);
        if (!profile.isPresent()) {
            throw new ApiRequestException("Failed to retrieve profile for ticker: " + ticker);
        }
        return profile;
    }
}

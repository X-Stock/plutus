package com.xstock.plutus.api.v1.profile;

import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class ProfileController implements CommonController<Profile> {
    private final ProfileService profileService;

    @Override
    @GetMapping(path = "/profile")
    public Profile getByTicker(@PathVariable String ticker) {
        return profileService.getByTicker(ticker);
    }
}

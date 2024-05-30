package com.xstock.plutus.v1.profile;

import com.xstock.plutus.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileService implements SingleResponseService<Profile> {
    private final ProfileRepository profileRepository;

    @Override
    public Profile getByTicker(String ticker) {
        Optional<Profile> profile = profileRepository.findByCompany_Ticker(ticker);
        return profile.orElseThrow(() -> new ResourceNotFoundException("profile by " + ticker));
    }

    @Override
    public Iterable<Profile> getAll() {
        Iterable<Profile> profiles = profileRepository.findAll();
        if (!profiles.iterator().hasNext()) {
            throw new ResourceNotFoundException("all profiles");
        }
        return profiles;
    }
}

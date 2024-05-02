package com.xstock.plutus.v1.profile;

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
        return profile.orElseThrow();
    }

    @Override
    public Iterable<Profile> getAll() {
        return profileRepository.findAll();
    }
}

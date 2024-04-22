package com.xstock.plutus.v1.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Iterable<Profile> getAll() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getByTicker(String ticker) {
        return profileRepository.findByCompany_Ticker(ticker);
    }
}

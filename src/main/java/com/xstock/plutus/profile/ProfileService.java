package com.xstock.plutus.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Iterable<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    public String addNewProfile(Profile profile) {
        profileRepository.save(profile);
        return "Saved profile";
    }
}

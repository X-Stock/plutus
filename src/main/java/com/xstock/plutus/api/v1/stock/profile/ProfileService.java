package com.xstock.plutus.api.v1.stock.profile;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileService implements CommonService<Profile> {
    private final ProfileRepository profileRepository;

    @Override
    public Profile getByTicker(String ticker) {
        Optional<Profile> profile = profileRepository.findByCompanyTicker(ticker);
        return profile.orElseThrow(ResourceNotFoundException::new);
    }
}

package com.xstock.plutus.api.stock.v1.profile;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "profile")
public class ProfileService implements CommonService<Profile> {
    private final ProfileRepository profileRepository;

    @Override
    @Cacheable
    public Profile getByTicker(String ticker) {
        Optional<Profile> profile = profileRepository.findByCompanyTicker(ticker);
        return profile.orElseThrow(ResourceNotFoundException::new);
    }
}

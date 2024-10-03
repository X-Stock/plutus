package com.xstock.plutus.api.stock.v1.overview;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "overview")
public class OverviewService implements CommonService<Overview> {
    private final OverviewRepository overviewRepository;

    @Override
    @Cacheable
    public Overview getByTicker(String ticker) {
        Optional<Overview> overview = overviewRepository.findByCompanyTicker(ticker);
        return overview.orElseThrow(ResourceNotFoundException::new);
    }
}

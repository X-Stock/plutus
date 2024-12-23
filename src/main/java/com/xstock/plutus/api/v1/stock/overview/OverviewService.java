package com.xstock.plutus.api.v1.stock.overview;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OverviewService implements CommonService<Overview> {
    private final OverviewRepository overviewRepository;

    @Override
    public Overview getByTicker(String ticker) {
        Optional<Overview> overview = overviewRepository.findByCompanyTicker(ticker);
        return overview.orElseThrow(ResourceNotFoundException::new);
    }
}

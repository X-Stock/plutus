package com.xstock.plutus.v1.overview;

import com.xstock.plutus.exception.ResourceNotFoundException;
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
        Optional<Overview> overview = overviewRepository.findByCompany_Ticker(ticker);
        return overview.orElseThrow(() -> new ResourceNotFoundException("overview by " + ticker));
    }
}

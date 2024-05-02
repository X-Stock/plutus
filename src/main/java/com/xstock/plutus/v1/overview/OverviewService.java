package com.xstock.plutus.v1.overview;

import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OverviewService implements SingleResponseService<Overview> {
    private final OverviewRepository overviewRepository;

    @Override
    public Overview getByTicker(String ticker) {
        Optional<Overview> overview = overviewRepository.findByCompany_Ticker(ticker);
        return overview.orElseThrow();
    }

    @Override
    public Iterable<Overview> getAll() {
        return overviewRepository.findAll();
    }
}

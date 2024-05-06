package com.xstock.plutus.v1.overview;

import com.xstock.plutus.exception.EntityNotFoundException;
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
        return overview.orElseThrow(() -> new EntityNotFoundException("overview by " + ticker));
    }

    @Override
    public Iterable<Overview> getAll() {
        Iterable<Overview> overviews = overviewRepository.findAll();
        if (!overviews.iterator().hasNext()) {
            throw new EntityNotFoundException("all overviews");
        }
        return overviews;
    }
}

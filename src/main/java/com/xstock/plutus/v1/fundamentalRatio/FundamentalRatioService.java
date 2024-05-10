package com.xstock.plutus.v1.fundamentalRatio;

import com.xstock.plutus.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FundamentalRatioService implements SingleResponseService<FundamentalRatio> {
    private final FundamentalRatioRepository fundamentalRatioRepository;

    @Override
    public FundamentalRatio getByTicker(String ticker) {
        Optional<FundamentalRatio> fundamentalRatio = fundamentalRatioRepository.findByCompany_Ticker(ticker);
        return fundamentalRatio.orElseThrow(() -> new ResourceNotFoundException("fundamental ratio by " + ticker));
    }

    @Override
    public Iterable<FundamentalRatio> getAll() {
        Iterable<FundamentalRatio> fundamentalRatios = fundamentalRatioRepository.findAll();
        if (!fundamentalRatios.iterator().hasNext()) {
            throw new ResourceNotFoundException("all fundamental ratios");
        }
        return fundamentalRatios;
    }
}

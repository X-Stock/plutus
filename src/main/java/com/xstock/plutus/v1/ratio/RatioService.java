package com.xstock.plutus.v1.ratio;

import com.xstock.plutus.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RatioService implements SingleResponseService<Ratio> {
    private final RatioRepository ratioRepository;

    @Override
    public Ratio getByTicker(String ticker) {
        Optional<Ratio> financialRatio = ratioRepository.findByCompany_Ticker(ticker);
        return financialRatio.orElseThrow(() -> new ResourceNotFoundException("financial ratio by " + ticker));
    }

    @Override
    public Iterable<Ratio> getAll() {
        Iterable<Ratio> ratios = ratioRepository.findAll();
        if (!ratios.iterator().hasNext()) {
            throw new ResourceNotFoundException("all financial ratios");
        }
        return ratios;
    }
}

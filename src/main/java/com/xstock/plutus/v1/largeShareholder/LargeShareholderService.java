package com.xstock.plutus.v1.largeShareholder;

import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LargeShareholderService implements MultiResponseService<LargeShareholder> {
    private final LargeShareholderRepository largeShareholderRepository;

    @Override
    public Iterable<LargeShareholder> getAllByTicker(String ticker) {
        return largeShareholderRepository.findAllByCompany_Ticker(ticker);
    }

    @Override
    public Iterable<LargeShareholder> getAll() {
        return largeShareholderRepository.findAll();
    }
}

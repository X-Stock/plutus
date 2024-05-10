package com.xstock.plutus.v1.largeShareholder;

import com.xstock.plutus.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LargeShareholderService implements MultiResponseService<LargeShareholder> {
    private final LargeShareholderRepository largeShareholderRepository;

    @Override
    public Iterable<LargeShareholder> getAllByTicker(String ticker) {
        Iterable<LargeShareholder> largeShareholders = largeShareholderRepository.findAllByCompany_Ticker(ticker);
        if (!largeShareholders.iterator().hasNext()) {
            throw new ResourceNotFoundException("large shareholders by " + ticker);
        }
        return largeShareholders;
    }

    @Override
    public Iterable<LargeShareholder> getAll() {
        Iterable<LargeShareholder> largeShareholders = largeShareholderRepository.findAll();
        if (!largeShareholders.iterator().hasNext()) {
            throw new ResourceNotFoundException("all large shareholders");
        }
        return largeShareholders;
    }
}

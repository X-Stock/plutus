package com.xstock.plutus.v1.largeShareholder;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LargeShareholderService implements CommonService<LargeShareholder> {
    private final LargeShareholderRepository largeShareholderRepository;

    @Override
    public List<LargeShareholder> getAllByTicker(String ticker, Pageable pageable) {
        Page<LargeShareholder> largeShareholders = largeShareholderRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "shareOwnPercent")))
        );
        if (largeShareholders.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return largeShareholders.getContent();
    }
}

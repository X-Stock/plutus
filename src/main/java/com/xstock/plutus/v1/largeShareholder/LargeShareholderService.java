package com.xstock.plutus.v1.largeShareholder;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "largeShareholders")
public class LargeShareholderService implements CommonService<LargeShareholder> {
    private final LargeShareholderRepository largeShareholderRepository;

    @Override
    @Cacheable
    public PaginatedResponse<LargeShareholder> getAllByTicker(String ticker, Pageable pageable) {
        Page<LargeShareholder> largeShareholders = largeShareholderRepository.findAllByCompanyTicker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "no")))
        );
        if (largeShareholders.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(largeShareholders.getTotalPages(), largeShareholders.getContent());
    }
}

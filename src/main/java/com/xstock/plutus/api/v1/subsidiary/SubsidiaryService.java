package com.xstock.plutus.api.v1.subsidiary;

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
@CacheConfig(cacheNames = "subsidiaries")
public class SubsidiaryService implements CommonService<Subsidiary> {
    private final SubsidiaryRepository subsidiaryRepository;

    @Override
    @Cacheable
    public PaginatedResponse<Subsidiary> getAllByTicker(String ticker, Pageable pageable) {
        Page<Subsidiary> subsidiaries = subsidiaryRepository.findAllByCompanyTicker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "no")))
        );
        if (subsidiaries.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(subsidiaries.getTotalPages(), subsidiaries.getContent());
    }
}

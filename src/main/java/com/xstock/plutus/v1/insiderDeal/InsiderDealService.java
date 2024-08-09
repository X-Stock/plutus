package com.xstock.plutus.v1.insiderDeal;

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
@CacheConfig(cacheNames = "insiderDeals")
public class InsiderDealService implements CommonService<InsiderDeal> {
    private final InsiderDealRepository insiderDealRepository;

    @Override
    @Cacheable
    public PaginatedResponse<InsiderDeal> getAllByTicker(String ticker, Pageable pageable) {
        Page<InsiderDeal> insiderDeals = insiderDealRepository.findAllByCompanyTicker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "dealAnnounceDate")))
        );
        if (insiderDeals.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(insiderDeals.getTotalPages(), insiderDeals.getContent());
    }
}

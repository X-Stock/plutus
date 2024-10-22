package com.xstock.plutus.api.stock.v1.insiderDeal;

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
    public PaginatedResponse<InsiderDeal> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "dealAnnounceDate");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<InsiderDeal> insiderDeals = insiderDealRepository.findAllByCompanyTicker(ticker, paging);
        if (insiderDeals.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(insiderDeals.getTotalPages(), insiderDeals.getContent());
    }
}

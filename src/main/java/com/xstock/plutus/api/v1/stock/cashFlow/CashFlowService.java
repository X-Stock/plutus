package com.xstock.plutus.api.v1.stock.cashFlow;

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
@CacheConfig(cacheNames = "cashFlows")
public class CashFlowService implements CommonService<CashFlow> {
    private final CashFlowRepository cashFlowRepository;

    @Override
    @Cacheable
    public PaginatedResponse<CashFlow> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "quarter", "year");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<CashFlow> cashFlows = cashFlowRepository.findAllByCompanyTicker(ticker, paging);
        if (cashFlows.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(cashFlows.getTotalPages(), cashFlows.getContent());
    }
}

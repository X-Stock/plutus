package com.xstock.plutus.v1.balanceSheet;

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
@CacheConfig(cacheNames = "balanceSheets")
public class BalanceSheetService implements CommonService<BalanceSheet> {
    private final BalanceSheetRepository balanceSheetRepository;

    @Override
    @Cacheable
    public PaginatedResponse<BalanceSheet> getAllByTicker(String ticker, Pageable pageable) {
        Page<BalanceSheet> balanceSheets = balanceSheetRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "quarter", "year")))
        );
        if (balanceSheets.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(balanceSheets.getTotalPages(), balanceSheets.getContent());
    }
}

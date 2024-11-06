package com.xstock.plutus.api.v1.stock.incomeStatement;

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
@CacheConfig(cacheNames = "incomeStatements")
public class IncomeStatementService implements CommonService<IncomeStatement> {
    private final IncomeStatementRepository incomeStatementRepository;

    @Override
    @Cacheable
    public PaginatedResponse<IncomeStatement> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "quarter", "year");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<IncomeStatement> incomeStatements = incomeStatementRepository.findAllByCompanyTicker(ticker, paging);
        if (incomeStatements.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(incomeStatements.getTotalPages(), incomeStatements.getContent());
    }
}

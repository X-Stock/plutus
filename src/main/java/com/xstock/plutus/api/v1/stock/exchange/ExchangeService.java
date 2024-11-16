package com.xstock.plutus.api.v1.stock.exchange;

import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
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
@CacheConfig(cacheNames = "exchanges")
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;

    @Cacheable
    public PaginatedResponse<Company> getCompaniesByExchange(String exchange, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.ASC, "ticker");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<Company> companies = exchangeRepository.findAllByExchange(exchange, paging);

        if (companies.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(companies.getTotalPages(), companies.getContent());
    }

    @Cacheable
    public Exchange getAll() {
        return new Exchange(exchangeRepository.findAll());
    }
}

package com.xstock.plutus.api.v1.stock.industry;

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

import java.util.List;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "industries")
public class IndustryService {
    private final IndustryRepository industryRepository;

    @Cacheable
    public PaginatedResponse<Company> getCompaniesByIndustry(String industry, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.ASC, "company.ticker");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<Company> companies = industryRepository.findCompaniesByIndustry(industry, paging);
        if (companies.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(companies.getTotalPages(), companies.getContent());
    }

    @Cacheable
    public Iterable<Industry> getAll() {
        List<Industry> industries = industryRepository.findAll();
        if (industries.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return industries;
    }
}

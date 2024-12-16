package com.xstock.plutus.api.v1.stock.company;

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

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "companies")
public class CompanyService implements CommonService<Company> {
    private final CompanyRepository companyRepository;

    @Override
    @Cacheable
    public Company getByTicker(String ticker) {
        Optional<Company> company = companyRepository.findByTicker(ticker);
        return company.orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    @Cacheable
    public PaginatedResponse<Company> getAll(Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.ASC, "ticker");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<Company> companies = companyRepository.findAll(paging);
        if (companies.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(companies.getTotalPages(), companies.getContent());
    }

    @Cacheable
    public PaginatedResponse<CompanyMetrics> getAllWithMetrics(Pageable pageable, boolean unpaged) {
        Pageable paging = unpaged
                ? Pageable.unpaged()
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        Page<Object[]> result = companyRepository.findAllWithMetrics(paging);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        List<CompanyMetrics> companies = result.getContent().stream()
                .map(CompanyMetrics::new)
                .toList();
        return new PaginatedResponse<>(result.getTotalPages(), companies);
    }
}

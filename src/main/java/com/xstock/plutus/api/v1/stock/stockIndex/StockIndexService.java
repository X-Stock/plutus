package com.xstock.plutus.api.v1.stock.stockIndex;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "indices")
public class StockIndexService implements CommonService<StockIndex> {
    private final StockIndexRepository stockIndexRepository;

    public PaginatedResponse<String> getAllByTicker(String ticker) {
        Page<StockIndex> stockIndices = stockIndexRepository.findAllByCompanyTicker(ticker,
                Pageable.unpaged(Sort.by(Sort.Direction.ASC, "indexName"))
        );

        if (stockIndices.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        List<String> indexNames = stockIndices.getContent().stream()
                .map(StockIndex::getIndexName)
                .toList();

        return new PaginatedResponse<>(null, indexNames);
    }

    @Override
    @Cacheable
    @Transactional(readOnly = true)
    public PaginatedResponse<StockIndex> getAll(Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.ASC, "indexName");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<StockIndex> stockIndices = stockIndexRepository.findAll(paging);

        if (stockIndices.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        List<StockIndex> indices = stockIndices.getContent();
        indices.parallelStream()
                .forEach(stockIndex -> Hibernate.initialize(stockIndex.getCompany()));
        return new PaginatedResponse<>(stockIndices.getTotalPages(), indices);
    }
}

package com.xstock.plutus.v1.stockIndex;

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
@CacheConfig(cacheNames = "indices")
public class StockIndexService implements CommonService<StockIndex> {
    private final StockIndexRepository stockIndexRepository;

    @Override
    @Cacheable
    public PaginatedResponse<StockIndex> getAllByTicker(String ticker, Pageable pageable) {
        Page<StockIndex> stockIndices = stockIndexRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "indexName")))
        );
        if (stockIndices.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockIndices.getTotalPages(), stockIndices.getContent());
    }

    @Override
    @Cacheable
    public PaginatedResponse<StockIndex> getAll(Pageable pageable) {
        Page<StockIndex> stockIndices = stockIndexRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "indexName"))
                )
        );
        if (stockIndices.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockIndices.getTotalPages(), stockIndices.getContent());
    }
}

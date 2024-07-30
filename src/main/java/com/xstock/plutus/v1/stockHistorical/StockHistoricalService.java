package com.xstock.plutus.v1.stockHistorical;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonController;
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
@CacheConfig(cacheNames = "stockHistorical")
public class StockHistoricalService implements CommonController<StockHistorical> {
    private final StockHistoricalRepository stockHistoricalRepository;

    @Override
    @Cacheable
    public PaginatedResponse<StockHistorical> getAllByTicker(String ticker, Pageable pageable) {
        Page<StockHistorical> stockHistorical = stockHistoricalRepository.findAllByCompany_Ticker(
                ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "time")))
        );
        if (stockHistorical.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockHistorical.getTotalPages(), stockHistorical.getContent());
    }
}

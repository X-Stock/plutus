package com.xstock.plutus.api.v1.stock.stockHistorical;

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

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "stockHistorical")
public class StockHistoricalService implements CommonController<StockHistorical> {
    private final StockHistoricalRepository stockHistoricalRepository;

    @Override
    @Cacheable
    public PaginatedResponse<StockHistorical> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<StockHistorical> stockHistorical = stockHistoricalRepository.findAllByCompanyTicker(ticker, paging);
        if (stockHistorical.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockHistorical.getTotalPages(), stockHistorical.getContent());
    }

    public PaginatedResponse<StockHistorical> getAllByTickerInRange(String ticker, OffsetDateTime startDate, OffsetDateTime endDate, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<StockHistorical> stockHistorical = stockHistoricalRepository.findAllByCompanyTickerInRange(ticker, startDate, endDate, paging);
        if (stockHistorical.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockHistorical.getTotalPages(), stockHistorical.getContent());
    }
}

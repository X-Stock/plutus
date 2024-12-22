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

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

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

    public PaginatedResponse<StockHistorical> getAllByTickerInRange(String ticker, LocalDate startDate, LocalDate endDate, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        OffsetDateTime offsetStartDate = OffsetDateTime.of(startDate.atStartOfDay(), ZoneOffset.UTC);
        OffsetDateTime offsetEndDate = OffsetDateTime.of(endDate.atStartOfDay(), ZoneOffset.UTC);

        Page<StockHistorical> stockHistorical = stockHistoricalRepository.findAllByCompanyTickerInRange(ticker, offsetStartDate, offsetEndDate, paging);
        if (stockHistorical.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockHistorical.getTotalPages(), stockHistorical.getContent());
    }

    public PaginatedResponse<StockHistoricalReturns> getReturnsByTicker(
            String ticker,
            String interval,
            Pageable pageable,
            boolean unpaged
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<StockHistoricalReturns> stockHistorical = stockHistoricalRepository.findReturnsByCompanyTicker(ticker, interval, paging);
        if (stockHistorical.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockHistorical.getTotalPages(), stockHistorical.getContent());
    }
}

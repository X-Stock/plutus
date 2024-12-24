package com.xstock.plutus.api.v1.stock.stockHistorical;

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

import java.time.Instant;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "stockHistorical")
public class StockHistoricalService {
    private final StockHistoricalRepository stockHistoricalRepository;

    public PaginatedResponse<StockHistorical> getAllByTicker(
            String ticker,
            Instant fromDate,
            Instant toDate,
            Pageable pageable,
            boolean unpaged
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<StockHistorical> stockHistorical;

        if (fromDate == null && toDate == null) {
            stockHistorical = stockHistoricalRepository.findAllByCompanyTicker(ticker, paging);
        } else if (toDate == null) {
            stockHistorical = stockHistoricalRepository.findAllByCompanyTickerFromDate(ticker, fromDate, paging);
        } else if (fromDate == null) {
            stockHistorical = stockHistoricalRepository.findAllByCompanyTickerToDate(ticker, toDate, paging);
        } else {
            stockHistorical = stockHistoricalRepository.findAllByCompanyTickerInRange(ticker, fromDate, toDate, paging);
        }

        if (stockHistorical.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockHistorical.getTotalPages(), stockHistorical.getContent());
    }

    @Cacheable
    public PaginatedResponse<StockHistoricalReturns> getReturnsByTicker(
            String ticker,
            String interval,
            Instant fromDate,
            Instant toDate,
            Pageable pageable,
            boolean unpaged
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<StockHistoricalReturns> stockHistorical;

        if (fromDate == null && toDate == null) {
            stockHistorical = stockHistoricalRepository.findReturnsByCompanyTicker(ticker, interval, paging);
        } else if (toDate == null) {
            stockHistorical = stockHistoricalRepository.findReturnsByCompanyTickerFromDate(ticker, interval, fromDate, paging);
        } else if (fromDate == null) {
            stockHistorical = stockHistoricalRepository.findReturnsByCompanyTickerToDate(ticker, interval, toDate, paging);
        } else {
            stockHistorical = stockHistoricalRepository.findReturnsByCompanyTickerInRange(ticker, interval, fromDate, toDate, paging);
        }

        if (stockHistorical.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockHistorical.getTotalPages(), stockHistorical.getContent());
    }
}

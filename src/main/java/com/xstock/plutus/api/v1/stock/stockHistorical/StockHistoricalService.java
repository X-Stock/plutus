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

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "stockHistorical")
public class StockHistoricalService {
    private final StockHistoricalRepository stockHistoricalRepository;

    public PaginatedResponse<StockHistorical> getAllByTicker(
            String ticker,
            LocalDate startDate,
            LocalDate endDate,
            Pageable pageable,
            boolean unpaged
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<StockHistorical> stockHistorical;

        OffsetDateTime offsetStartDate = null;
        OffsetDateTime offsetEndDate = null;
        if (startDate != null) {
            offsetStartDate = OffsetDateTime.of(startDate.atStartOfDay(), ZoneOffset.UTC);
        }
        if (endDate != null) {
            offsetEndDate = OffsetDateTime.of(endDate.atStartOfDay(), ZoneOffset.UTC);
        }
        if (offsetStartDate == null && offsetEndDate == null) {
            stockHistorical = stockHistoricalRepository.findAllByCompanyTicker(ticker, paging);
        } else if (offsetEndDate == null) {
            stockHistorical = stockHistoricalRepository.findAllByCompanyTickerFromDate(ticker, offsetStartDate, paging);
        } else if (offsetStartDate == null) {
            stockHistorical = stockHistoricalRepository.findAllByCompanyTickerToDate(ticker, offsetEndDate, paging);
        } else {
            stockHistorical = stockHistoricalRepository.findAllByCompanyTickerInRange(ticker, offsetStartDate, offsetEndDate, paging);
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
            LocalDate startDate,
            LocalDate endDate,
            Pageable pageable,
            boolean unpaged
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<StockHistoricalReturns> stockHistorical;

        OffsetDateTime offsetStartDate = null;
        OffsetDateTime offsetEndDate = null;
        if (startDate != null) {
            offsetStartDate = OffsetDateTime.of(startDate.atStartOfDay(), ZoneOffset.UTC);
        }
        if (endDate != null) {
            offsetEndDate = OffsetDateTime.of(endDate.atStartOfDay(), ZoneOffset.UTC);
        }
        if (offsetStartDate == null && offsetEndDate == null) {
            stockHistorical = stockHistoricalRepository.findReturnsByCompanyTicker(ticker, interval, paging);
        } else if (offsetEndDate == null) {
            stockHistorical = stockHistoricalRepository.findReturnsByCompanyTickerFromDate(ticker, interval, offsetStartDate, paging);
        } else if (offsetStartDate == null) {
            stockHistorical = stockHistoricalRepository.findReturnsByCompanyTickerToDate(ticker, interval, offsetEndDate, paging);
        } else {
            stockHistorical = stockHistoricalRepository.findReturnsByCompanyTickerInRange(ticker, interval, offsetStartDate, offsetEndDate, paging);
        }

        if (stockHistorical.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockHistorical.getTotalPages(), stockHistorical.getContent());
    }
}

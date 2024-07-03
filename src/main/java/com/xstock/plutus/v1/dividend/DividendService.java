package com.xstock.plutus.v1.dividend;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DividendService implements CommonService<Dividend> {
    private final DividendRepository dividendRepository;

    @Override
    public PaginatedResponse<Dividend> getAllByTicker(String ticker, Pageable pageable) {
        Page<Dividend> dividends = dividendRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "exerciseDate")))
        );
        if (dividends.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(dividends.getTotalPages(), dividends.getContent());
    }
}
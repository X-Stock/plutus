package com.xstock.plutus.v1.stockIndex;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StockIndexService implements CommonService<StockIndex> {
    private final StockIndexRepository stockIndexRepository;

    public PaginatedResponse<String> getAllByTicker(String ticker) {
        Page<StockIndex> stockIndices = stockIndexRepository.findAllByCompany_Ticker(ticker,
                Pageable.unpaged(Sort.by(Sort.Direction.ASC, "indexName"))
        );

        if (stockIndices.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        List<String> contents = new ArrayList<>();
        for (var content : stockIndices.getContent()) {
            contents.add(content.getIndexName());
        }
        return new PaginatedResponse<>(null, contents);
    }

    @Override
    @Transactional(readOnly = true)
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

        var contents = stockIndices.getContent();
        for (var content : contents) {
            Hibernate.initialize(content.getCompany());
        }
        return new PaginatedResponse<>(stockIndices.getTotalPages(), contents);
    }
}

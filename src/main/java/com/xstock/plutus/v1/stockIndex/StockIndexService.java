package com.xstock.plutus.v1.stockIndex;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StockIndexService implements CommonService<StockIndex> {
    private final StockIndexRepository stockIndexRepository;

    @Override
    public List<StockIndex> getAllByTicker(String ticker, Pageable pageable) {
        Page<StockIndex> stockIndices = stockIndexRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "indexName")))
        );
        if (stockIndices.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return stockIndices.getContent();
    }

    @Override
    public List<StockIndex> getAll(Pageable pageable) {
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
        return stockIndices.getContent();
    }
}

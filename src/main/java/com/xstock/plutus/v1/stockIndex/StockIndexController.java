package com.xstock.plutus.v1.stockIndex;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class StockIndexController implements CommonController<StockIndex> {
    private final StockIndexService stockIndexService;

    @Override
    @GetMapping(path = "/companies/{ticker}/stockIndices")
    public PaginatedResponse<StockIndex> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return stockIndexService.getAllByTicker(ticker, pageable);
    }

    @GetMapping(path = "/stockIndices")
    public PaginatedResponse<StockIndex> getAll(Pageable pageable) {
        return stockIndexService.getAll(pageable);
    }
}

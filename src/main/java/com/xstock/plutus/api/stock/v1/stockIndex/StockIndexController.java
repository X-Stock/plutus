package com.xstock.plutus.api.stock.v1.stockIndex;

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

    @GetMapping(path = "/companies/{ticker}/stockIndices")
    public PaginatedResponse<String> getAllByTicker(@PathVariable String ticker) {
        return stockIndexService.getAllByTicker(ticker);
    }

    @Override
    @GetMapping(path = "/stockIndices")
    public PaginatedResponse<StockIndex> getAll(Pageable pageable) {
        return stockIndexService.getAll(pageable);
    }
}

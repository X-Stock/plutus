package com.xstock.plutus.api.v1.stock.stockIndex;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class StockIndexController implements CommonController<StockIndex> {
    private final StockIndexService stockIndexService;

    @GetMapping(path = "/companies/{ticker}/stock-indices")
    public PaginatedResponse<String> getAllByTicker(String ticker) {
        return stockIndexService.getAllByTicker(ticker);
    }

    @Override
    @GetMapping(path = "/stock-indices")
    public PaginatedResponse<StockIndex> getAll(Pageable pageable, boolean unpaged) {
        return stockIndexService.getAll(pageable, unpaged);
    }
}

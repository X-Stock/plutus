package com.xstock.plutus.api.v1.stock.stockIntraday;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class StockIntradayController {
    private final StockIntradayService stockIntradayService;

    @GetMapping("/stock-intraday")
    public SseEmitter getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return stockIntradayService.getIntraday(ticker, pageable, unpaged);
    }
}

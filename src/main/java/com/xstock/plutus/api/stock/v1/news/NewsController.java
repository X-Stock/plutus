package com.xstock.plutus.api.stock.v1.news;

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
public class NewsController implements CommonController<News> {
    private final NewsService newsService;

    @Override
    @GetMapping(path = "/companies/{ticker}/news")
    public PaginatedResponse<News> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return newsService.getAllByTicker(ticker, pageable);
    }

    @GetMapping(path = "/news")
    public PaginatedResponse<News> getAll(Pageable pageable) {
        return newsService.getAll(pageable);
    }
}

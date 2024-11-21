package com.xstock.plutus.api.v1.stock.news;

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
public class NewsController implements CommonController<News> {
    private final NewsService newsService;

    @Override
    @GetMapping(path = "/companies/{ticker}/news")
    public PaginatedResponse<News> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return newsService.getAllByTicker(ticker, pageable, unpaged);
    }

    @GetMapping(path = "/news")
    public PaginatedResponse<News> getAll(Pageable pageable, boolean unpaged) {
        return newsService.getAll(pageable, unpaged);
    }
}

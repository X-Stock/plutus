package com.xstock.plutus.v1.news;

import com.xstock.plutus.utils.interfaces.controller.MultiResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class NewsController implements MultiResponseController<News> {
    private final NewsService newsService;

    @Override
    @GetMapping(path = "/companies/{ticker}/news")
    public Iterable<News> getAllByTicker(@PathVariable String ticker) {
        return newsService.getAllByTicker(ticker);
    }

    @GetMapping(path = "/news")
    public Iterable<News> getAll() {
        return newsService.getAll();
    }
}

package com.xstock.plutus.v1.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping(path = "/news")
    public Iterable<News> getAll() {
        return newsService.getAll();
    }

    @GetMapping(path = "/companies/{ticker}/news")
    public Iterable<News> getAllByTicker(@PathVariable String ticker) {
        return newsService.getAllByTicker(ticker);
    }
}

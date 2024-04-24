package com.xstock.plutus.v1.news;

import com.xstock.plutus.exception.ApiRequestException;
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
        Iterable<News> news = newsService.getAll();
        if (news == null) {
            throw new ApiRequestException("Failed to retrieve all news.");
        }
        return news;
    }

    @GetMapping(path = "/companies/{ticker}/news")
    public Iterable<News> getAllByTicker(@PathVariable String ticker) {
        Iterable<News> news = newsService.getAllByTicker(ticker);
        if (news == null) {
            throw new ApiRequestException("Failed to retrieve news for ticker: " + ticker);
        }
        return news;
    }
}

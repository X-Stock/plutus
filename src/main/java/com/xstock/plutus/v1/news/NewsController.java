package com.xstock.plutus.v1.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public Iterable<News> getNews() {
        return newsService.getNews();
    }

    @PostMapping(path = "/add")
    public String addNewNews(@RequestBody News news) {
        return newsService.addNewNews(news);
    }
}

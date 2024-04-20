package com.xstock.plutus.v1.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public Iterable<News> getNews() {
        return newsRepository.findAll();
    }

    public String addNewNews(News news) {
        newsRepository.save(news);
        return "Saved news";
    }
}

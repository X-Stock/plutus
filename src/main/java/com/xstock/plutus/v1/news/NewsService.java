package com.xstock.plutus.v1.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public Iterable<News> getAll() {
        return newsRepository.findAll();
    }

    public Iterable<News> getAllByTicker(String ticker) {
        return newsRepository.findAllByCompany_Ticker(ticker);
    }
}

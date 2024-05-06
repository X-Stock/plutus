package com.xstock.plutus.v1.news;

import com.xstock.plutus.exception.EntityNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NewsService implements MultiResponseService<News> {
    private final NewsRepository newsRepository;

    @Override
    public Iterable<News> getAllByTicker(String ticker) {
        Iterable<News> news = newsRepository.findAllByCompany_Ticker(ticker);
        if (!news.iterator().hasNext()) {
            throw new EntityNotFoundException("news by " + ticker);
        }
        return news;
    }

    @Override
    public Iterable<News> getAll() {
        Iterable<News> news = newsRepository.findAll();
        if (!news.iterator().hasNext()) {
            throw new EntityNotFoundException("all news");
        }
        return news;
    }
}

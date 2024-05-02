package com.xstock.plutus.v1.news;

import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NewsService implements MultiResponseService<News> {
    private final NewsRepository newsRepository;

    @Override
    public Iterable<News> getAllByTicker(String ticker) {
        return newsRepository.findAllByCompany_Ticker(ticker);
    }

    @Override
    public Iterable<News> getAll() {
        return newsRepository.findAll();
    }
}

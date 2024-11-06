package com.xstock.plutus.api.v1.stock.news;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "news")
public class NewsService implements CommonService<News> {
    private final NewsRepository newsRepository;

    @Override
    @Cacheable
    public PaginatedResponse<News> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "publishDate");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<News> news = newsRepository.findAllByCompanyTicker(ticker, paging);
        if (news.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(news.getTotalPages(), news.getContent());
    }

    @Override
    @Cacheable
    public PaginatedResponse<News> getAll(Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "publishDate");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<News> news = newsRepository.findAll(paging);
        if (news.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(news.getTotalPages(), news.getContent());
    }
}

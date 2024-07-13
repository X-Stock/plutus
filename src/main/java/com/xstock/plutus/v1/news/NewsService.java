package com.xstock.plutus.v1.news;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NewsService implements CommonService<News> {
    private final NewsRepository newsRepository;

    @Override
    public PaginatedResponse<News> getAllByTicker(String ticker, Pageable pageable) {
        Page<News> news = newsRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "publishDate")))
        );
        if (news.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(news.getTotalPages(), news.getContent());
    }

    @Override
    public PaginatedResponse<News> getAll(Pageable pageable) {
        Page<News> news = newsRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "publishDate")))
        );
        if (news.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(news.getTotalPages(), news.getContent());
    }
}

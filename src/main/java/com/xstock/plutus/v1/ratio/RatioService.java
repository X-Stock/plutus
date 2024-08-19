package com.xstock.plutus.v1.ratio;

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
@CacheConfig(cacheNames = "ratio")
public class RatioService implements CommonService<Ratio> {
    private final RatioRepository ratioRepository;

    @Override
    @Cacheable
    public PaginatedResponse<Ratio> getAllByTicker(String ticker, Pageable pageable) {
        Page<Ratio> ratios = ratioRepository.findAllByCompanyTicker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "quarter", "year")))
        );
        if (ratios.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(ratios.getTotalPages(), ratios.getContent());
    }
}

package com.xstock.plutus.api.v1.stock.ratio;

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
public class RatioService implements CommonService<Ratio> {
    private final RatioRepository ratioRepository;

    @Override
    public PaginatedResponse<Ratio> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "quarter", "year");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<Ratio> ratios = ratioRepository.findAllByCompanyTicker(ticker, paging);
        if (ratios.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(ratios.getTotalPages(), ratios.getContent());
    }
}

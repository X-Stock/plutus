package com.xstock.plutus.api.v1.stock.largeShareholder;

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
public class LargeShareholderService implements CommonService<LargeShareholder> {
    private final LargeShareholderRepository largeShareholderRepository;

    @Override
    public PaginatedResponse<LargeShareholder> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.ASC, "no");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<LargeShareholder> largeShareholders = largeShareholderRepository.findAllByCompanyTicker(ticker, paging);
        if (largeShareholders.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(largeShareholders.getTotalPages(), largeShareholders.getContent());
    }
}

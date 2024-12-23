package com.xstock.plutus.api.v1.stock.balanceSheet;

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
public class BalanceSheetService implements CommonService<BalanceSheet> {
    private final BalanceSheetRepository balanceSheetRepository;

    @Override
    public PaginatedResponse<BalanceSheet> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "quarter", "year");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<BalanceSheet> balanceSheets = balanceSheetRepository.findAllByCompanyTicker(ticker, paging);
        if (balanceSheets.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(balanceSheets.getTotalPages(), balanceSheets.getContent());
    }
}

package com.xstock.plutus.api.v1.stock.officer;

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
public class OfficerService implements CommonService<Officer> {
    private final OfficerRepository officerRepository;

    @Override
    public PaginatedResponse<Officer> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.ASC, "no");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<Officer> officers = officerRepository.findAllByCompanyTicker(ticker, paging);
        if (officers.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(officers.getTotalPages(), officers.getContent());
    }
}

package com.xstock.plutus.v1.subsidiary;

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
public class SubsidiaryService implements CommonService<Subsidiary> {
    private final SubsidiaryRepository subsidiaryRepository;

    @Override
    public PaginatedResponse<Subsidiary> getAllByTicker(String ticker, Pageable pageable) {
        Page<Subsidiary> subsidiaries = subsidiaryRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "ownPercent")))
        );
        if (subsidiaries.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(subsidiaries.getTotalPages(), subsidiaries.getContent());
    }
}

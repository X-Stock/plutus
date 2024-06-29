package com.xstock.plutus.v1.officer;

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
    public Iterable<Officer> getAllByTicker(String ticker, Pageable pageable) {
        Page<Officer> officers = officerRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "own_percent")))
        );
        if (officers.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return officers.getContent();
    }
}

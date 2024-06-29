package com.xstock.plutus.v1.ratio;

import com.xstock.plutus.exception.ResourceNotFoundException;
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
    public Iterable<Ratio> getAllByTicker(String ticker, Pageable pageable) {
        Page<Ratio> ratios = ratioRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "quarter", "year")))
        );
        if (ratios.isEmpty()) {
            throw new ResourceNotFoundException("all ratios");
        }
        return ratios.getContent();
    }
}

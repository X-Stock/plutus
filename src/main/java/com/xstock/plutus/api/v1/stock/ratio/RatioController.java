package com.xstock.plutus.api.v1.stock.ratio;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class RatioController implements CommonController<Ratio> {
    private final RatioService ratioService;

    @Override
    @GetMapping(path = "/ratio")
    public PaginatedResponse<Ratio> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return ratioService.getAllByTicker(ticker, pageable, unpaged);
    }
}

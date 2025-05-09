package com.xstock.plutus.api.v1.stock.officer;

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
public class OfficerController implements CommonController<Officer> {
    private final OfficerService officerService;

    @Override
    @GetMapping(path = "/officers")
    public PaginatedResponse<Officer> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return officerService.getAllByTicker(ticker, pageable, unpaged);
    }
}

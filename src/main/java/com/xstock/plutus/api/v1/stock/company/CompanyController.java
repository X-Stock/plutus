package com.xstock.plutus.api.v1.stock.company;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies")
public class CompanyController implements CommonController<Company> {
    private final CompanyService companyService;

    @Override
    @GetMapping("/{ticker}")
    public Company getByTicker(String ticker) {
        return companyService.getByTicker(ticker);
    }

    @Override
    @GetMapping
    public PaginatedResponse<Company> getAll(Pageable pageable, boolean unpaged) {
        return companyService.getAll(pageable, unpaged);
    }

    @GetMapping("/metrics")
    public PaginatedResponse<CompanyMetrics> getCompaniesByIndustry(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged) {
        return companyService.getAllWithMetrics(pageable, unpaged);
    }
}

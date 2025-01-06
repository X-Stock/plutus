package com.xstock.plutus.api.v1.stock.industry;

import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.utils.dto.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/industries")
@RestController
public class IndustryController {
    private final IndustryService industryService;

    @GetMapping("/{industry}")
    public PaginatedResponse<Company> getCompaniesByIndustry(
            @PathVariable String industry,
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged) {
        return industryService.getCompaniesByIndustry(industry, pageable, unpaged);
    }

    @GetMapping
    public Map<String, Iterable<Industry>> getAll() {
        return Map.of("industries", industryService.getAll());
    }
}

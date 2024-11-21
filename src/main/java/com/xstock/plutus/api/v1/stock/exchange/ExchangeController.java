package com.xstock.plutus.api.v1.stock.exchange;

import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.utils.dto.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/exchanges")
public class ExchangeController {
    private final ExchangeService exchangeService;

    @GetMapping("/{exchange}")
    public PaginatedResponse<Company> getCompaniesByExchange(@PathVariable String exchange, Pageable pageable, boolean unpaged) {
        return exchangeService.getCompaniesByExchange(exchange, pageable, unpaged);
    }

    @GetMapping
    public Exchange getAll() {
        return exchangeService.getAll();
    }
}

package com.xstock.plutus.api.v1.stock.industry;

import com.xstock.plutus.api.v1.stock.company.Company;

public record Industry(
        String industry,
        Iterable<Company> companies
) {}
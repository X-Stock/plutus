package com.xstock.plutus.api.v1.stock.company;

public record CompanyMetrics(
        String ticker,
        String fullnameVi,
        String industryEn,
        Float returns,
        Float volatility,
        Float ratio
) {
    public CompanyMetrics(Object[] objects) {
        this(
                (String) objects[0],
                (String) objects[1],
                (String) objects[2],
                (Float) objects[3],
                (Float) objects[4],
                (Float) objects[5]
        );
    }
}

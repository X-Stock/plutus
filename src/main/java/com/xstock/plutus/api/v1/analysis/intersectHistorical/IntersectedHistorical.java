package com.xstock.plutus.api.v1.analysis.intersectHistorical;

import java.util.List;

public record IntersectedHistorical<T>(
        String ticker,
        List<T> historical
) {}

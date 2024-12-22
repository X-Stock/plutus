package com.xstock.plutus.api.v1.analysis.portfolio;

import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;

import java.util.List;

public record IntersectedHistorical(
        String ticker,
        List<StockHistoricalReturns> historical
) {}

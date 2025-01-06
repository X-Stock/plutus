package com.xstock.plutus.api.v1.stock.company;

public interface CompanyMetrics {
    String getTicker();
    String getFullnameVi();
    String getIndustryEn();
    Integer getCurrentPrice();
    Float getPriceDiff();
    Float getReturns();
    Float getVolatility();
    Float getRatio();
}
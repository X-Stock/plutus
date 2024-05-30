package com.xstock.plutus.utils.interfaces.service;

public interface SingleResponseService<T> extends CommonService<T> {
    T getByTicker(String ticker);
}

package com.xstock.plutus.utils.interfaces.service;

public interface MultiResponseService<T> extends CommonService<T> {
    Iterable<T> getAllByTicker(String ticker);
}

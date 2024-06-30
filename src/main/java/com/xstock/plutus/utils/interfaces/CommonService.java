package com.xstock.plutus.utils.interfaces;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommonService<T> {
    default T getByTicker(String ticker) {
        throw new UnsupportedOperationException();
    }

    default List<T> getAllByTicker(String ticker, Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    default List<T> getAll(Pageable pageable) {
        throw new UnsupportedOperationException();
    }
}

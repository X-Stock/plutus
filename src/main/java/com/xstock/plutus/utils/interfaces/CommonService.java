package com.xstock.plutus.utils.interfaces;

import org.springframework.data.domain.Pageable;

public interface CommonService<T> {
    default T getByTicker(String ticker) {
        throw new UnsupportedOperationException();
    }

    default Iterable<T> getAllByTicker(String ticker, Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    default Iterable<T> getAll(Pageable pageable) {
        throw new UnsupportedOperationException();
    }
}

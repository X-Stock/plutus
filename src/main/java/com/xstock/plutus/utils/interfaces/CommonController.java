package com.xstock.plutus.utils.interfaces;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1")
public interface CommonController<T> {
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

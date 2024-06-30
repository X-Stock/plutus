package com.xstock.plutus.utils.interfaces;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1")
public interface CommonController<T> {
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

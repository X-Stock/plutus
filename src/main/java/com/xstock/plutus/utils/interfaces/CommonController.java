package com.xstock.plutus.utils.interfaces;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1")
public interface CommonController<T> {
    default T getByTicker(String ticker) {
        throw new UnsupportedOperationException();
    }

    default PaginatedResponse<T> getAllByTicker(String ticker, Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    default PaginatedResponse<T> getAll(Pageable pageable) {
        throw new UnsupportedOperationException();
    }
}

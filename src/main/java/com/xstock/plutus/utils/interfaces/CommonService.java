package com.xstock.plutus.utils.interfaces;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface CommonService<T> {
    default T getByTicker(String ticker) {
        throw new UnsupportedOperationException();
    }

    default PaginatedResponse<T> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        throw new UnsupportedOperationException();
    }

    default PaginatedResponse<T> getAll(Pageable pageable, boolean unpaged) {
        throw new UnsupportedOperationException();
    }
}

package com.xstock.plutus.utils.interfaces;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path = "/api/v1")
public interface CommonController<T> {
    default T getByTicker(@PathVariable String ticker) {
        throw new UnsupportedOperationException();
    }

    default PaginatedResponse<T> getAllByTicker(
            @PathVariable String ticker,
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged) {
        throw new UnsupportedOperationException();
    }

    default PaginatedResponse<T> getAll(
           @ParameterObject Pageable pageable,
           @RequestParam(defaultValue = "false") boolean unpaged) {
        throw new UnsupportedOperationException();
    }
}

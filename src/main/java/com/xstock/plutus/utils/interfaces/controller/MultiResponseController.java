package com.xstock.plutus.utils.interfaces.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface MultiResponseController<T> extends CommonController<T> {
    @GetMapping("{ticker}")
    Iterable<T> getAllByTicker(String ticker);
}

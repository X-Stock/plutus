package com.xstock.plutus.utils.interfaces.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface SingleResponseController<T> extends CommonController<T> {
    @GetMapping("/{ticker}")
    T getByTicker(String ticker);
}

package com.xstock.plutus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * This does not override Spring default Pageable injection in controller methods.
 */
@Configuration(proxyBeanMethods = false)
public class PageRequestConfig {
    private static final int defaultPage = 0;

    private static final int defaultSize = 20;

    @Bean
    public PageRequest defaultPageRequest() {
        return PageRequest.of(defaultPage, defaultSize, Sort.unsorted());
    }
}

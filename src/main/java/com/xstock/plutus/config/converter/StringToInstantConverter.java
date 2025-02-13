package com.xstock.plutus.config.converter;

import com.xstock.plutus.utils.parsers.InstantParser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class StringToInstantConverter implements Converter<String, Instant> {

    @Override
    public Instant convert(@NonNull String source) {
        return InstantParser.parse(source);
    }
}

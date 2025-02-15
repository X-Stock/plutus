package com.xstock.plutus.utils.parsers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InstantParser {
    public static Instant parse(String source) {
        if (source.isBlank()) {
            return null;
        }

        try {
            return Instant.parse(source);
        } catch (DateTimeParseException e) {
            LocalDate date = LocalDate.parse(source, DateTimeFormatter.ISO_DATE);
            return date.atStartOfDay().toInstant(ZoneOffset.UTC);
        }
    }
}

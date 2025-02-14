package com.xstock.plutus.config.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.xstock.plutus.utils.parsers.InstantParser;

import java.io.IOException;
import java.time.Instant;

class InstantDeserializer extends JsonDeserializer<Instant> {
    @Override
    public Instant deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        String value = p.getText();
        return InstantParser.parse(value);
    }
}


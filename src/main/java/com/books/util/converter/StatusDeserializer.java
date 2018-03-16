package com.books.util.converter;

import com.books.entities.enums.STATUS;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class StatusDeserializer extends StdDeserializer<STATUS> {

    public StatusDeserializer() {
        super(STATUS.class);
    }

    @Override
    public STATUS deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return STATUS.fromValue(jsonParser.getValueAsString());
    }
}

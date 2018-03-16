
package com.books.util.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by ham.heitormartins on 14/04/2017.
 */
public class CustomLocalDateTimeDeserialize extends StdDeserializer<LocalDateTime> {

    private static final long serialVersionUID = 1L;

    public CustomLocalDateTimeDeserialize() {
        super(LocalDateTime.class);
    }


    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalDateTime.parse(p.getValueAsString()); // or overloaded with an appropriate format
    }
}
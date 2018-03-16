package com.books.util.converter;

import com.books.entities.enums.STATUS;
import org.springframework.core.convert.converter.Converter;

public class StatusConverter implements Converter<String, STATUS> {

    @Override
    public STATUS convert(String s) {
        return STATUS.fromValue(s);
    }
}

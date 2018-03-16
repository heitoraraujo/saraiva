package com.books.util.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */

public class CbcValidator<T> {

    List<T> erros = Collections.EMPTY_LIST;

    public CbcValidator() {
        erros = new ArrayList<T>();
    }

    public static CbcValidator ensureThat() {
        return new CbcValidator();
    }

    public CbcValidator assertNotNull(Object value, T errorMessage) {
        if (value == null) {
            erros.add(errorMessage);
        }

        return this;
    }

    public CbcValidator assertNotEmpty(String value, T errorMessage) {
        if (StringUtils.isEmpty(value)) {
            erros.add(errorMessage);
        }
        return this;
    }

    public CbcValidator assertTrue(boolean value, T errorMessage) {
        if (!value) {
            erros.add(errorMessage);
        }

        return this;
    }

    public CbcValidator assertFalse(boolean value, T errorMessage) {
        if (value) {
            erros.add(errorMessage);
        }

        return this;
    }

    public CbcValidator assertMaxSize(String value, Integer size, T errorMessage) {
        if (!StringUtils.isEmpty(value) && value.length() > size) {
            erros.add(errorMessage);
        }

        return this;
    }

    public CbcValidator assertMinSize(Long value, Integer size, T errorMessage) {
        if (value != null && value < size) {
            erros.add(errorMessage);
        }

        return this;
    }

    public CbcValidator assertAreSame(Object firstValue, Object secondValue, T errorMessage) {
        if ((firstValue != null && secondValue != null) && !firstValue.equals(secondValue)) {
            erros.add(errorMessage);
        }

        return this;
    }

    public boolean hasErrors() {
        return !erros.isEmpty();
    }

    public List<T> errors() {
        return erros;
    }
}

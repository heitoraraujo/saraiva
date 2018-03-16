package com.books.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class CbcFieldValidationException extends RuntimeException {

    private List<FieldErrorMessage> fieldErrorMessage;
    private HttpStatus httpStatus;

    public CbcFieldValidationException(FieldErrorMessage fieldErrorMessage, HttpStatus httpStatus) {
        this.fieldErrorMessage = Arrays.asList(fieldErrorMessage);
        this.httpStatus = httpStatus;
    }

    public CbcFieldValidationException(List<FieldErrorMessage> fieldErrorMessage, HttpStatus httpStatus) {
        this.fieldErrorMessage = fieldErrorMessage;
        this.httpStatus = httpStatus;
    }

    public List<FieldErrorMessage> getFieldErrorMessages() {
        return fieldErrorMessage;
    }

    public void setFieldErrorMessage(List<FieldErrorMessage> fieldErrorMessage) {
        this.fieldErrorMessage = fieldErrorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}

package com.books.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
/**
 * Created by ham.heitormartins on 15/03/2018.
 */
public class CbcValidationException extends RuntimeException {

    private List<ErrorMessage> errorMessages = Collections.EMPTY_LIST;
    private HttpStatus httpStatus;

    public CbcValidationException(List<ErrorMessage> errorMessages, HttpStatus httpStatus) {
        this.errorMessages = errorMessages;
        this.httpStatus = httpStatus;
    }

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
 }

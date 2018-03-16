package com.books.dto.erroresponse;

import com.books.exception.FieldErrorMessage;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
public class FieldErrorResponseDTO {

    @JsonProperty("erros")
    private List<FieldErrorMessage> fieldErrorMessages;

    public FieldErrorResponseDTO(List<FieldErrorMessage> fieldErrorMessages) {
        this.fieldErrorMessages = fieldErrorMessages;
    }

    public List<FieldErrorMessage> getFieldErrorMessages() {
        return fieldErrorMessages;
    }

    public void setFieldErrorMessages(List<FieldErrorMessage> fieldErrorMessages) {
        this.fieldErrorMessages = fieldErrorMessages;
    }
}

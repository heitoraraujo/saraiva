package com.books.dto.erroresponse;

import com.books.exception.ErrorMessage;

import java.util.List;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
public class ErrorResponseDTO {

    private List<ErrorMessage> messages;

    public ErrorResponseDTO(List<ErrorMessage> messages) {
        this.messages = messages;
    }

    public List<ErrorMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ErrorMessage> messages) {
        this.messages = messages;
    }
}

package com.books.exception;


import com.books.dto.erroresponse.ErrorResponseDTO;
import com.books.dto.erroresponse.FieldErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CbcExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CbcValidationException.class })
    protected ResponseEntity<ErrorResponseDTO> handleCbcValidationException(CbcValidationException exception, WebRequest request) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(exception.getErrorMessages());

        return new ResponseEntity<ErrorResponseDTO>(errorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler(value = {CbcFieldValidationException.class })
    protected ResponseEntity<FieldErrorResponseDTO> handleCbcValidationException(CbcFieldValidationException exception, WebRequest request) {
        FieldErrorResponseDTO fieldErrorResponse = new FieldErrorResponseDTO(exception.getFieldErrorMessages());

        return new ResponseEntity<FieldErrorResponseDTO>(fieldErrorResponse, exception.getHttpStatus());
    }
}


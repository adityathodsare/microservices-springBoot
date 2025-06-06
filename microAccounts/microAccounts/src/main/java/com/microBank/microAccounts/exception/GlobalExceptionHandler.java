package com.microBank.microAccounts.exception;



import com.microBank.microAccounts.DTO.ErrorResponceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler extends  RuntimeException{
    private final WebRequest webRequest;

    public GlobalExceptionHandler(WebRequest webRequest) {
        this.webRequest = webRequest;
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponceDTO> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception) {
        ErrorResponceDTO errorResponceDTO = new ErrorResponceDTO(
                webRequest.getDescription(false), // we ll get only api not much info needed
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponceDTO, HttpStatus.BAD_REQUEST);

    }

}

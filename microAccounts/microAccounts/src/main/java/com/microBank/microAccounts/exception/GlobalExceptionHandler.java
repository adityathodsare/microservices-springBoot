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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponceDTO> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorResponceDTO errorResponceDTO = new ErrorResponceDTO(
                webRequest.getDescription(false), // we ll get only api not much info needed
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponceDTO, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponceDTO> handleGlobalException(Exception exception) {
        ErrorResponceDTO errorResponceDTO = new ErrorResponceDTO(
                webRequest.getDescription(false), // we ll get only api not much info needed
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponceDTO, HttpStatus.NOT_FOUND);

    }
}

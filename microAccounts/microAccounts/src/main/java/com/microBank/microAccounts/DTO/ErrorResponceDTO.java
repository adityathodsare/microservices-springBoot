package com.microBank.microAccounts.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponceDTO {
    private String apiPAth;

    private HttpStatus errorCode;

    private String errorMessage;

    private LocalDateTime errorTime;
    
}

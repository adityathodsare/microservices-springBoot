package com.microBank.microAccounts.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Schema(description = "Error Response ", name = "ErrorResponce")
@Data
@AllArgsConstructor
public class ErrorResponceDTO {

    @Schema(description = "API Path", example = "/accounts/fetch/{mobileNumber}")
    private String apiPAth;

    @Schema(description = "Error Code", example = "500")
    private HttpStatus errorCode;

    @Schema(description = "Error Message", example = "Internal Server Error")
    private String errorMessage;

    @Schema(description = "Error Time", example = "2023-01-01T00:00:00")
    private LocalDateTime errorTime;
    
}

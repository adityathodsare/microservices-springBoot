package com.microBank.microAccounts.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Responce Object")
public class ResponceDTO {

    @Schema(description = "Status Code", example = "200")
    private String statueCode;

    @Schema(description = "Status Message", example = "Success")
    private String statusMessage;

}

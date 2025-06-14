package com.microBank.microAccounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Schema(description = "Customer details", name = "Customer")
@Data
public class CustomerDTO {


    @Schema(description = "Customer name", example = "aditya amol thodsare", required = true)
    @NotEmpty(message = "the name cannot be null or empty")
    @Size(min = 5, max = 25, message = "the name must be between 5 and 25 characters")
    private String name;

    @Schema(description = "Customer email", example = "thodsareaditya@gmail.com", required = true)
    @NotEmpty(message = "the email cannot be null or empty")
    @Email(message = "the email must be valid")
    private  String email;

    @Schema(description = "Customer mobile number", example = "1234567890", required = true)
    @NotEmpty(message = "the mobile number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private  String mobileNumber;

    @Schema(description = "account related details (Object)")
    private  AccountsDTO accountsDTO;

}

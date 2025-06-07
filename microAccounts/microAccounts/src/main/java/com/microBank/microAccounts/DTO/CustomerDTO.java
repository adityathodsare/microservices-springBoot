package com.microBank.microAccounts.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {


    @NotEmpty(message = "the name cannot be null or empty")
    @Size(min = 5, max = 25, message = "the name must be between 5 and 25 characters")
    private String name;

    @NotEmpty(message = "the email cannot be null or empty")
    @Email(message = "the email must be valid")
    private  String email;

    @NotEmpty(message = "the mobile number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private  String mobileNumber;

    private  AccountsDTO accountsDTO;

}

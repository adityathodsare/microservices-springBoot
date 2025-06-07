package com.microBank.microAccounts.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDTO {


    @NotEmpty(message = "The account number cannot be null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    private Long accountNumber;


    @NotEmpty(message = "the account type cannot be null or empty")
    private String accountType;

    @NotEmpty(message = "the branch address cannot be null or empty")
    private String branchAddress;
}

package com.microBank.microAccounts.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Schema(description = "Account related details", name = "Accounts")
@Data
public class AccountsDTO {


    @Schema(description = "Account number", example = "1234567890")
    @NotEmpty(message = "The account number cannot be null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    private Long accountNumber;


    @Schema(description = "Account type", example = "Savings")
    @NotEmpty(message = "the account type cannot be null or empty")
    private String accountType;


    @Schema(description = "Branch address", example = "Pune")
    @NotEmpty(message = "the branch address cannot be null or empty")
    private String branchAddress;
}

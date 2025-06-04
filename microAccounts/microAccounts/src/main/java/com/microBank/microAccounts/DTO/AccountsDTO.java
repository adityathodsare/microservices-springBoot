package com.microBank.microAccounts.DTO;


import lombok.Data;

@Data
public class AccountsDTO {


    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}

package com.microBank.microAccounts.DTO;

import lombok.Data;

@Data
public class CustomerDTO {

    private String name;

    private  String email;

    private  String mobileNumber;

    private  AccountsDTO accountsDTO;

}

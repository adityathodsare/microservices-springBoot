package com.microBank.microAccounts.controller;

import com.microBank.microAccounts.DTO.CustomerDTO;
import com.microBank.microAccounts.DTO.ResponceDTO;
import com.microBank.microAccounts.constants.AccountsConstants;
import com.microBank.microAccounts.entity.Accounts;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces =( MediaType.APPLICATION_JSON_VALUE))
public class AccountsController {


    @PostMapping("/accounts/{customerDTO}")
    public ResponseEntity<ResponceDTO> createAccount(@PathVariable CustomerDTO customerDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponceDTO(AccountsConstants.STATUS_201 , AccountsConstants.MESSAGE_201));

    }



}

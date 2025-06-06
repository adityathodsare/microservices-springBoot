package com.microBank.microAccounts.controller;

import com.microBank.microAccounts.DTO.CustomerDTO;
import com.microBank.microAccounts.DTO.ResponceDTO;
import com.microBank.microAccounts.constants.AccountsConstants;
import com.microBank.microAccounts.entity.Accounts;
import com.microBank.microAccounts.repository.AccountsRepository;
import com.microBank.microAccounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces =( MediaType.APPLICATION_JSON_VALUE))
public class AccountsController {

    private final IAccountService accountService ;

    public AccountsController(IAccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/create")
    public ResponseEntity<ResponceDTO> createAccount(@RequestBody CustomerDTO customerDTO) {

        accountService.createAccount(customerDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponceDTO(AccountsConstants.STATUS_201 , AccountsConstants.MESSAGE_201));

    }



}

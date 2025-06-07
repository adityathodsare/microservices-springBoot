package com.microBank.microAccounts.controller;

import com.microBank.microAccounts.DTO.CustomerDTO;
import com.microBank.microAccounts.DTO.ResponceDTO;
import com.microBank.microAccounts.constants.AccountsConstants;
import com.microBank.microAccounts.service.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces =( MediaType.APPLICATION_JSON_VALUE))
@Validated
public class AccountsController {

    private final IAccountService accountService ;

    public AccountsController(IAccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/create")
    public ResponseEntity<ResponceDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO) {

        accountService.createAccount(customerDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponceDTO(AccountsConstants.STATUS_201 , AccountsConstants.MESSAGE_201));

    }

    @GetMapping("/fetch/{mobileNumber}")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@PathVariable String mobileNumber) {

        CustomerDTO customerDTO = accountService.fetchAccount(mobileNumber) ;
        return  ResponseEntity.status(HttpStatus.OK).body(customerDTO);

    }


    @PutMapping("/update")
    public ResponseEntity<ResponceDTO> updateAccountDetails( @Valid @RequestBody CustomerDTO customerDTO) {
        boolean isUpdated = accountService.updateAccount(customerDTO) ;
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponceDTO(AccountsConstants.STATUS_200 , AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponceDTO(AccountsConstants.STATUS_500  , AccountsConstants.MESSAGE_500));
        }
    }



    @DeleteMapping("/delete/{mobileNumber}")
    public ResponseEntity<ResponceDTO> deleteAccountDetails(@PathVariable @Pattern(regexp = "\\d{10}" ) String mobileNumber) {
        boolean isDeleted = accountService.deleteAccount(mobileNumber) ;
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponceDTO(AccountsConstants.STATUS_200 , AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponceDTO(AccountsConstants.STATUS_500  , AccountsConstants.MESSAGE_500));
        }
    }



}

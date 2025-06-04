package com.microBank.microAccounts.service.impl;

import com.microBank.microAccounts.DTO.CustomerDTO;
import com.microBank.microAccounts.repository.AccountsRepository;
import com.microBank.microAccounts.repository.CustomerRepository;
import com.microBank.microAccounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class IAccountServiceImpl implements IAccountService {

    private AccountsRepository accountRepository ;
    private CustomerRepository customerRepository ;


    @Override
    public void createAccount(CustomerDTO customerDTO) {

    }
}

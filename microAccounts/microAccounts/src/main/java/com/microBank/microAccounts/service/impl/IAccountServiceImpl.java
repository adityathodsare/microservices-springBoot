package com.microBank.microAccounts.service.impl;

import com.microBank.microAccounts.DTO.AccountsDTO;
import com.microBank.microAccounts.DTO.CustomerDTO;
import com.microBank.microAccounts.constants.AccountsConstants;
import com.microBank.microAccounts.entity.Accounts;
import com.microBank.microAccounts.entity.Customer;
import com.microBank.microAccounts.exception.CustomerAlreadyExistsException;
import com.microBank.microAccounts.exception.ResourceNotFoundException;
import com.microBank.microAccounts.mapper.AccountsMapper;
import com.microBank.microAccounts.mapper.CustomerMapper;
import com.microBank.microAccounts.repository.AccountsRepository;
import com.microBank.microAccounts.repository.CustomerRepository;
import com.microBank.microAccounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class IAccountServiceImpl implements IAccountService {

    private AccountsRepository accountRepository ;
    private CustomerRepository customerRepository ;


    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());

        Optional<Customer> optionalCustomer  =
                customerRepository.findByMobileNumber(customerDTO.getMobileNumber());

        if (optionalCustomer.isPresent()) {
            throw  new CustomerAlreadyExistsException("Customer already exists / mobile number already exists "
                    + customerDTO.getMobileNumber());
        }

//        customer.setCreatedAt(LocalDateTime.now());
//        customer.setCreatedBy("Admin1");



        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));


    }
    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
//        newAccount.setCreatedAt(LocalDateTime.now());
//        newAccount.setCreatedBy("Admin1");

        return newAccount;
    }


    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Customer", "mobileNumber",mobileNumber)
        );

        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Accounts", "customerId", String.valueOf(customer.getCustomerId()))
                );

        CustomerDTO customerDTO= CustomerMapper.mapToCustomerDTO(customer, new CustomerDTO());
        customerDTO.setAccountsDTO(AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO()));



        return  customerDTO ;


    }

    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        AccountsDTO accountsDto = customerDTO.getAccountsDTO();
        if(accountsDto !=null ) {
            Accounts accounts = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDTO, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }

        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountRepository.deleteByCustomerId(customer.getCustomerId());

        customerRepository.deleteById(customer.getCustomerId());

        return true;
    }
}

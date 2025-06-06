package com.microBank.microAccounts.repository;


import com.microBank.microAccounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // derived Name method
    Optional<Customer> findByMobileNumber(String mobileNumber);

}

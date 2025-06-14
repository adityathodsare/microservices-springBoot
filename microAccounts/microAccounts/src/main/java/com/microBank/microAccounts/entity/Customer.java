package com.microBank.microAccounts.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends  BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long  customerId;

    private String name;

    private  String email;

    private  String mobileNumber;
}


package com.microBank.microAccounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {

    @GetMapping("/demo")
    public String demo() {
        return "hello sir hello";
        
    }
}

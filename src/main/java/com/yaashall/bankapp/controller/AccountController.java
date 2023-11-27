package com.yaashall.bankapp.controller;

import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.CreateAccountRequest;
import com.yaashall.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/create")
    @ResponseStatus(code= HttpStatus.CREATED)
    public BankResponse createAccount(@RequestBody CreateAccountRequest request){

        return accountService.createAccountForUser(request.getEmail());
    }
}

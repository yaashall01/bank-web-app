package com.yaashall.bankapp.controller;

import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.CreateAccountRequest;
import com.yaashall.bankapp.entity.User;
import com.yaashall.bankapp.service.AccountService;
import com.yaashall.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public BankResponse createAccount(@RequestBody CreateAccountRequest request){

        return accountService.createAccountForUser(request.getEmail());
    }
}

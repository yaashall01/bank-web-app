package com.yaashall.bankapp.controller;

import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.UserRequest;
import com.yaashall.bankapp.entity.Account;
import com.yaashall.bankapp.entity.User;
import com.yaashall.bankapp.service.AccountService;
import com.yaashall.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BankResponse createUser(@RequestBody UserRequest userRequest){

        User user = userService.createUser(userRequest);

        BankResponse bankResponse = accountService.createAccountForUser(user);

        return bankResponse;
    }


}

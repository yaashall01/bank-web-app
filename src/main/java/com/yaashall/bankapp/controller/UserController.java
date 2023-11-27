package com.yaashall.bankapp.controller;

import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.UserRequest;
import com.yaashall.bankapp.dto.UserResponse;
import com.yaashall.bankapp.entity.User;
import com.yaashall.bankapp.service.AccountService;
import com.yaashall.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public BankResponse signUp(@RequestBody UserRequest userRequest){
        return userService.registerUser(userRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

}

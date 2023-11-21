package com.yaashall.bankapp.service;

import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.UserRequest;
import com.yaashall.bankapp.dto.UserResponse;
import com.yaashall.bankapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    /**
     * Sign up a user
     *
     * @param userRequest
     * @return Bankresponse
     */
    BankResponse registerUser(UserRequest userRequest);


    List<UserResponse> getAllUsers();

    Optional<User> getUserById(Long id);

    User getUserByEmail(String email);


    User updateUser(Long id, UserRequest userRequest);

    boolean deleteUser(Long id);



}

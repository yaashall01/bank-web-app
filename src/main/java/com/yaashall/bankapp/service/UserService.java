package com.yaashall.bankapp.service;

import com.yaashall.bankapp.dto.AccountInfo;
import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.UserRequest;
import com.yaashall.bankapp.entity.User;

import java.util.List;

public interface UserService {


    User createUser(UserRequest userRequest);


    /**
     * Create a user
     *
     * @param userRequest
     * @return
     */
    //BankResponse createUser(UserRequest userRequest);

    /**
     * Get a user
     *
     * @param accountNumber
     * @return
     */
    //BankResponse getUser(String accountNumber);

    /**
     * Update a user
     *
     * @param accountNumber
     * @param userRequest
     * @return
     */
    //BankResponse updateUser(String accountNumber, UserRequest userRequest);

    /**
     * Delete a user
     *
     * @param accountNumber
     * @return
     */
    //BankResponse deleteUser(String accountNumber);

    /**
     * Get all accounts for a user
     *
     * @param userId
     * @return
     */
    //List<AccountInfo> getAccountsForUser(Long userId);

}

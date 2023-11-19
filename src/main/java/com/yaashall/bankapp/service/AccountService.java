package com.yaashall.bankapp.service;


import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.entity.Account;
import com.yaashall.bankapp.entity.User;

public interface AccountService {




    /**
     * Create an account for a user
     *
     * @param user
     * @return a response indicating the success or failure of the operation
     */
    BankResponse createAccountForUser(User user);

    /**
     * Get an account
     *
     * @param accountId
     * @return
     */
    //Account getAccount(Long accountId);

    /**
     * Get an account
     *
     * @param userId
     * @return
     */
    //BankResponse getAccountByUserId(Long userId);
    /**
     * Get an account
     *
     * @param accountNumber
     * @return
     */
    //BankResponse getAccountByAccountNumber(String accountNumber);

    /**
     * Update an account
     *
     * @param accountId
     * @param balance
     * @return
     */
    //BankResponse updateAccount(Long accountId, Double balance);
    /**
     * Delete an account
     *
     * @param accountId
     * @return
     */
    //BankResponse deleteAccount(Long accountId);

    /**
     * Deposits a certain amount into an account.
     *
     * @param accountId the ID of the account to deposit into
     * @param amount the amount to deposit
     * @return a response indicating the success or failure of the operation
     */
    //BankResponse deposit(Long accountId, Double amount);

    /**
     * Withdraws a certain amount from an account.
     *
     * @param accountId the ID of the account to withdraw from
     * @param amount the amount to withdraw
     * @return a response indicating the success or failure of the operation
     */
    //BankResponse withdraw(Long accountId, Double amount);

    /**
     * Transfers money from one account to another.
     *
     * @param fromAccountId the ID of the account to transfer from
     * @param toAccountId the ID of the account to transfer to
     * @param amount the amount to transfer
     * @return a response indicating the success or failure of the operation
     */
    //BankResponse transfer(Long fromAccountId, Long toAccountId, Double amount);



}

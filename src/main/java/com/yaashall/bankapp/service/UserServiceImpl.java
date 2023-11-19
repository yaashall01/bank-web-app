package com.yaashall.bankapp.service.core;

import com.yaashall.bankapp.dto.AccountInfo;
import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.UserRequest;

import java.util.List;

public class UserServiceImpl implements UserService {


    @Override
    public BankResponse createUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public BankResponse getUser(String accountNumber) {
        return null;
    }

    @Override
    public BankResponse updateUser(String accountNumber, UserRequest userRequest) {
        return null;
    }

    @Override
    public BankResponse deleteUser(String accountNumber) {
        return null;
    }

    @Override
    public List<AccountInfo> getAccountsForUser(Long userId) {
        return null;
    }
}

package com.yaashall.bankapp.service.core;

import com.yaashall.bankapp.dto.AccountInfo;
import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.UserRequest;

import java.util.List;

public interface UserService {

    BankResponse createUser(UserRequest userRequest);
    BankResponse getUser(String accountNumber);
    BankResponse updateUser(String accountNumber, UserRequest userRequest);
    BankResponse deleteUser(String accountNumber);
    List<AccountInfo> getAccountsForUser(Long userId);

}

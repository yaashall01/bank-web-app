package com.yaashall.bankapp.service;

import com.yaashall.bankapp.dto.AccountInfo;
import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.entity.Account;
import com.yaashall.bankapp.entity.User;
import com.yaashall.bankapp.repository.AccountRepository;
import com.yaashall.bankapp.repository.UserRepository;
import com.yaashall.bankapp.utils.AccountUtils.AccountNumberGenerator;
import com.yaashall.bankapp.utils.AccountUtils.AccountStatus;
import com.yaashall.bankapp.utils.AccountUtils.AccountType;
import com.yaashall.bankapp.utils.BankUtils.BankResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;



    @Override
    public BankResponse createAccountForUser(User user) {
        // Assuming there's a method to get the existing account. You need to implement this
        Account existingAccount = accountRepository.findByUserUserId(user.getUserId());

        if(existingAccount != null){


            AccountInfo accountInfo = AccountInfo.builder()
                    .accountNumber(existingAccount.getAccountNumber())
                    .accountType(existingAccount.getAccountType())
                    .accountStatus(existingAccount.getAccountStatus())
                    .accountBalance(existingAccount.getBalance().toString())
                    .build();

            return BankResponse.builder()
                    .respCode(BankResp.ACCOUNT_EXISTS.getRespCode())
                    .respMessage(BankResp.ACCOUNT_EXISTS.getRespMessage())
                    .accountInfo(accountInfo)
                    .build();
        }

        // Generate a unique account number, later i'll add initial balance and prefix to the account number matching AccountType
        String accountNumber = AccountNumberGenerator.generateAccountNumber("10");

        // Create a new account
        Account newAccount = Account.builder()
                .accountNumber(accountNumber)
                .balance(BigDecimal.ZERO)
                .accountStatus(AccountStatus.INACTIVE)
                .accountType(AccountType.SAVINGS)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .user(user)
                .build();

        // Save the new account
        Account savedAccount = accountRepository.save(newAccount);

        AccountInfo accountInfo = AccountInfo.builder()
                .accountNumber(savedAccount.getAccountNumber())
                .accountType(savedAccount.getAccountType())
                .accountStatus(savedAccount.getAccountStatus())
                .accountBalance(savedAccount.getBalance().toString())
                .build();

        return BankResponse.builder()
                .respCode(BankResp.ACCOUNT_CREATED.getRespCode())
                .respMessage(BankResp.ACCOUNT_CREATED.getRespMessage())
                .accountInfo(accountInfo)
                .build();
    }
}

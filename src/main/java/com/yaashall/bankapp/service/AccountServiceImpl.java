package com.yaashall.bankapp.service;

import com.yaashall.bankapp.dto.AccountInfo;
import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.EmailMessage;
import com.yaashall.bankapp.entity.Account;
import com.yaashall.bankapp.entity.User;
import com.yaashall.bankapp.repository.AccountRepository;
import com.yaashall.bankapp.repository.UserRepository;
import com.yaashall.bankapp.utils.accountutils.AccountNumberGenerator;
import com.yaashall.bankapp.utils.accountutils.AccountStatus;
import com.yaashall.bankapp.utils.accountutils.AccountType;
import com.yaashall.bankapp.utils.bankutils.BankResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;


    @Transactional
    @Override
    public BankResponse createAccountForUser(User user) {
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

        // Send email to user
        EmailMessage emailMessage = EmailMessage.builder()
                .toAddress(user.getEmail())
                .subject("Account Creation")
                .body("Your account has been created successfully. Your account number is " + savedAccount.getAccountNumber())
                .isHtml(true)
                .build();
        emailService.accountCreationEmail(emailMessage);

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


    @Transactional
    @Override
    public BankResponse createAccountForUser(String email) {

        User user = userService.getUserByEmail(email);

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

    //Later on, each user will be able to have multiple accounts.
    @Override
    public BankResponse addAccountToUser(Long userId) {
        return null;
    }

    /*
    public BankResponse addAccountToUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getAccounts().size() >= 5) {
            throw new RuntimeException("Maximum number of accounts reached");
        }

        newAccount.setUser(user);
        user.getAccounts().add(newAccount);
        userRepository.save(user);
        return BankResponse.builder()
                .respCode(BankResp.ACCOUNT_CREATED.getRespCode())
                .respMessage(BankResp.ACCOUNT_CREATED.getRespMessage())
                .build()
    }

     */
}

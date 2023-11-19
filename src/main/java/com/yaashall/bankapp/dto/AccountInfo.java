package com.yaashall.bankapp.dto;

import com.yaashall.bankapp.utils.AccountUtils.AccountStatus;
import com.yaashall.bankapp.utils.AccountUtils.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {

    private String accountNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private String accountBalance;
}

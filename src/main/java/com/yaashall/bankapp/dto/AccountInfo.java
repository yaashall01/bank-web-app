package com.yaashall.bankapp.dto;

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
    private String accountName;
    private String accountType;
    private String accountBalance;
}

package com.yaashall.bankapp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankResponse {

    private String respCode;
    private String respMessage;
    private AccountInfo accountInfo;
}

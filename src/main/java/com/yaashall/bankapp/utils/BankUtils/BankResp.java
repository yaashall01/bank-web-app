package com.yaashall.bankapp.utils.BankUtils;

public enum BankResp {

    ACCOUNT_EXISTS("001", "Account already exists"),
    ACCOUNT_NOT_FOUND("002", "Account not found"),
    ACCOUNT_CREATED("003", "Account created successfully"),
    ACCOUNT_UPDATED("004", "Account updated successfully"),
    ACCOUNT_DELETED("005", "Account deleted successfully"),
    ACCOUNT_ACTIVATED("006", "Account activated successfully"),
    ACCOUNT_DEACTIVATED("007", "Account deactivated successfully"),
    ACCOUNT_SUSPENDED("008", "Account suspended successfully"),
    ACCOUNT_REACTIVATED("009", "Account reactivated successfully"),
    ACCOUNT_CLOSED("010", "Account closed successfully");

    private final String respCode;
    private final String respMessage;

    BankResp(String respCode, String respMessage) {
        this.respCode = respCode;
        this.respMessage = respMessage;
    }

    public String getRespCode(){
        return respCode;
    }

    public String getRespMessage(){
        return respMessage;
    }

}

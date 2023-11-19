package com.yaashall.bankapp.utils.AccountUtils;

public enum AccountType {
    SAVINGS("Savings Account"),
    CHECKING("Checking Account"),
    CREDIT("Credit Account"),
    FIXED_DEPOSIT("Fixed Deposit Account"),
    CURRENT("Current Account");

    private final String displayName;

    AccountType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}


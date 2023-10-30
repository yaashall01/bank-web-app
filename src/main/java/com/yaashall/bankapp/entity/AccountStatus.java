package com.yaashall.bankapp.entity;

public enum AccountStatus {
    ACTIVE,          // Account is active and in good standing.
    FROZEN,          // Account has been temporarily frozen, e.g., due to suspicious activity.
    CLOSED,          // Account has been closed, usually by request of the account holder.
    INACTIVE,        // Account is inactive, perhaps due to inactivity for an extended period.
    BLOCKED,         // Account has been blocked or restricted.
    OVERDUE,         // Account is overdue on payments.
    PENDING_APPROVAL // Account is pending approval, e.g., for a new account application.
}

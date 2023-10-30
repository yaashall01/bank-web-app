package com.yaashall.bankapp.repository;

import com.yaashall.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository
        extends JpaRepository<Account, Long> {
}

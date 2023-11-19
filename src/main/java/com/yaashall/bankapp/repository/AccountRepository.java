package com.yaashall.bankapp.repository;

import com.yaashall.bankapp.entity.Account;
import com.yaashall.bankapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AccountRepository
        extends JpaRepository<Account, Long> {


    boolean findByUser(User user);

    Account findByUserUserId(Long userId);
}

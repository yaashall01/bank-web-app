package com.yaashall.bankapp.repository;
import com.yaashall.bankapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {
}

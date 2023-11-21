package com.yaashall.bankapp.repository;
import com.yaashall.bankapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository
        extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByUserId(Long userId);

    Boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);

    Optional<User> findByUserId(Long id);

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.userId = ?1")
    Optional<User> findUserById(Long id);

}

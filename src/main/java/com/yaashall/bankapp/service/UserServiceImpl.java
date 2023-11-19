package com.yaashall.bankapp.service;

import com.yaashall.bankapp.dto.AccountInfo;
import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.UserRequest;
import com.yaashall.bankapp.entity.User;
import com.yaashall.bankapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(UserRequest userRequest){

        User user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .birthPlace(userRequest.getBirthPlace())
                .birthDate(userRequest.getBirthDate())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .phoneNumber(userRequest.getPhoneNumber())
                .build();

        return userRepository.save(user);
    }





}

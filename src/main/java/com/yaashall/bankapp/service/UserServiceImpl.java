package com.yaashall.bankapp.service;

import com.yaashall.bankapp.dto.BankResponse;
import com.yaashall.bankapp.dto.UserRequest;
import com.yaashall.bankapp.dto.UserResponse;
import com.yaashall.bankapp.entity.User;
import com.yaashall.bankapp.repository.UserRepository;
import com.yaashall.bankapp.utils.bankutils.BankResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    //sign up a user
    public BankResponse registerUser(UserRequest userRequest){

        if (userRepository.existsByEmailOrPhoneNumber(userRequest.getEmail(), userRequest.getPhoneNumber())) {
            return BankResponse.builder()
                    .respCode(BankResp.USER_EXISTS.getRespCode())
                    .respMessage(BankResp.USER_EXISTS.getRespMessage())
                    .build();
        }

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
        userRepository.save(user);


        return BankResponse.builder()
                .respCode(BankResp.USER_CREATED.getRespCode())
                .respMessage(BankResp.USER_CREATED.getRespMessage())
                .build();
    }


    @Transactional
    @Override
    public Optional<User> getUserById(Long id) {
        if (!userRepository.existsByUserId(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return userRepository.findUserById(id);
    }


    @Override
    public List<UserResponse> getAllUsers() {

        List<UserResponse> users = new ArrayList<>();
        for (User user : userRepository.findAll()){
            UserResponse userResponse = new UserResponse(user);
            users.add(userResponse);
        }

        return users;
    }
    @Transactional
    @Override
    public User getUserByEmail(String email) {
        if (!userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return userRepository.findByEmail(email);

    }



    @Override
    public User updateUser(Long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }


}

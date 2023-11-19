package com.yaashall.bankapp.dto;

import com.yaashall.bankapp.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String birthPlace;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String phoneNumber;

}

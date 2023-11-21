package com.yaashall.bankapp.dto;

import com.yaashall.bankapp.entity.User;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String birthPlace;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;

    public UserResponse(User user){
        this(user.getFirstName(),
          user.getLastName(),
          user.getGender(),
          user.getAddress(),
          user.getBirthPlace(),
          user.getBirthDate(),
          user.getPhoneNumber(),
          user.getEmail());

    }

}

package com.yaashall.bankapp.dto;


import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
public class CreateAccountRequest {

    @Email(message = "Please enter a valid email address")
    private String email;
}

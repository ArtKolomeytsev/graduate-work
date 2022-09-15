package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginReq {
    @NotBlank
    private String password;
    @NotBlank
    @Email
    private String username;
}

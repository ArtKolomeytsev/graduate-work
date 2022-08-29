package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class UsersDto {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}

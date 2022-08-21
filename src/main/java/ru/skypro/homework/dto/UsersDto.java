package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class UsersDto {
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private Integer id;
    private String email;
}

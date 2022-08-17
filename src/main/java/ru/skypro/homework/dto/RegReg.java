package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class RegReg {

    private String password;

    public enum RoleEnum {
        ADMIN("ADMIN"),
        USER("USER");

        RoleEnum(String value) {

        }
        }

    private RoleEnum roleEnum;
    private String username;
}

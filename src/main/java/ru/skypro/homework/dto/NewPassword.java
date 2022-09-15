package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class NewPassword {
    @Size(min = 6)
    private String newPassword;
    @Size(min = 6)
    private String currentPassword;
}

package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateAdsDto {
    private Integer price;
    @NotBlank
    @Size(min = 20)
    private String description;
    @NotBlank
    @Size(min = 3)
    private String title;
}

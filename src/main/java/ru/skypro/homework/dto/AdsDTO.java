package ru.skypro.homework.dto;


import lombok.Data;

@Data
public class AdsDTO {
    private Integer author;
    private Integer pk;
    private Double price;
    private String title;
    private String description;
}

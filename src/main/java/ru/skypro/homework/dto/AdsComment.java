package ru.skypro.homework.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class AdsComment {
    private Integer author;
    private OffsetDateTime dateTime;
    private Integer pk;
    private String text;
}

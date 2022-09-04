package ru.skypro.homework.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class AdsCommentDto {
    private Integer pk;
    private Integer author;
    private OffsetDateTime dateTime;
    private String text;
}

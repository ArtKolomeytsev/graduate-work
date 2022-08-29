package ru.skypro.homework.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class AdsCommentDto {
    private Integer author;
    private OffsetDateTime dateTime;
    private Integer pk;
    private String text;
}

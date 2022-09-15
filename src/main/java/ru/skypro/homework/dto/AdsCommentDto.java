package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;

@Data
public class AdsCommentDto {
    private Integer pk;
    private Integer author;
    private OffsetDateTime dateTime;
    @NotBlank
    private String text;
}

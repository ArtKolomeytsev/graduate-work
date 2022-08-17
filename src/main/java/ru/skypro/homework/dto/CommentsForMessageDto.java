package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class CommentsForMessageDto {
    private String idComment;

    private String comment;

    private String messages;
}

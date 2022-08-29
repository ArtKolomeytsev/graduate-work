package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class ImagesForMessageDto {
    private String imgId;

    private String mediaType;

    private byte[] content;

    private String messages;
}

package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.GetImageDto;

public interface AdvertImageService {

    Integer saveImage(MultipartFile multipartFile);

    GetImageDto getImage(Integer id);
}

package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.GetImageDto;

public interface AdvertImageService {

    Integer saveImage(Integer id, MultipartFile multipartFile);

    byte[] getImage(Integer id);
}

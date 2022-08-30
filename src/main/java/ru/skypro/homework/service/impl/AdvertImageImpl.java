package ru.skypro.homework.service.impl;

import liquibase.pro.packaged.A;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.GetImageDto;
import ru.skypro.homework.entities.AdvertImages;
import ru.skypro.homework.mapper.ImageMapper;
import ru.skypro.homework.repo.AdvertImageRepo;
import ru.skypro.homework.service.AdvertImageService;

import java.io.IOException;
@Service
public class AdvertImageImpl implements AdvertImageService {

    private final AdvertImageRepo advertImageRepo;
    private final ImageMapper imageMapper;

    public AdvertImageImpl(AdvertImageRepo advertImageRepo, ImageMapper imageMapper) {
        this.advertImageRepo = advertImageRepo;
        this.imageMapper = imageMapper;
    }

    @Override
    public void saveImage(MultipartFile file) {
        AdvertImages advertImages = new AdvertImages();
        try {
            byte[] bytes = file.getBytes();
            String mediaType = file.getContentType();
            advertImages.setContent(bytes);
            advertImages.setMediaType(mediaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AdvertImages saveImage = advertImageRepo.save(advertImages);
    }

    @Override
    public GetImageDto getImage(Integer id) {
        GetImageDto getImageDto = new GetImageDto();
        AdvertImages advertImages = advertImageRepo.findById(id).get();
        if (advertImageRepo.findById(id).isPresent()) {
            getImageDto.setContent(advertImages.getContent());
        }
        return getImageDto;
    }
}

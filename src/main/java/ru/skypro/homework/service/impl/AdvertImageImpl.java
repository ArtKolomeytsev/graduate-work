package ru.skypro.homework.service.impl;

import liquibase.pro.packaged.A;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.GetImageDto;
import ru.skypro.homework.entities.Ads;
import ru.skypro.homework.entities.AdvertImages;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.mapper.ImageMapper;
import ru.skypro.homework.repo.AdvertImageRepo;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.AdvertImageService;

import java.io.IOException;
import java.util.Optional;

@Service
public class AdvertImageImpl implements AdvertImageService {

    private final AdvertImageRepo advertImageRepo;
    private final ImageMapper imageMapper;
    private final AdsService adsService;
    private final AdsMapper adsMapper;

    public AdvertImageImpl(AdvertImageRepo advertImageRepo, ImageMapper imageMapper, AdsService adsService, AdsMapper adsMapper) {
        this.advertImageRepo = advertImageRepo;
        this.imageMapper = imageMapper;
        this.adsService = adsService;
        this.adsMapper = adsMapper;
    }

    @Override
    public Integer saveImage(Integer id, MultipartFile file) {
        AdvertImages advertImages = new AdvertImages();
        try {
            byte[] bytes = file.getBytes();
            String mediaType = file.getContentType();
            advertImages.setContent(bytes);
            advertImages.setMediaType(mediaType);
            advertImages.setMessages(adsService.findByMessId(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AdvertImages saveImage = advertImageRepo.save(advertImages);
        return saveImage.getImgId();
    }

    @Override
    public byte[] getImage(Integer id) {
        Optional<AdvertImages> advertImages = advertImageRepo.findById(id);
        byte[] image = null;
        if (advertImageRepo.findById(id).isPresent()) {
            image = advertImages.get().getContent();
        }
        return image;
    }
}

package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;

import java.util.List;

public interface AdsService {

    public List<ResponseWrapperAds> getAllAds();

    public void createAds(CreateAds createAds);

    public List<ResponseWrapperAds> getAllAdsByUserId();

    public void deleteAds();

    public FullAds getAdsById();

    public AdsDTO updateAds(AdsDTO);
}

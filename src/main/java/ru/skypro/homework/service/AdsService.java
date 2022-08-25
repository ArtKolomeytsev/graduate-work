package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;

import java.util.List;

public interface AdsService {

    public ResponseWrapperAds getAllAds();

    public void createAds(CreateAds createAds);

    public ResponseWrapperAds getAllMyAds(String username);

    public void deleteAds();

    public FullAds getAdsById(Integer id);

    public AdsDTO updateAds(AdsDTO adsDTO);
}

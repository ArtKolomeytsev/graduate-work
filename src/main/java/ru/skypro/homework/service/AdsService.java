package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Ads;

public interface AdsService {

    public ResponseWrapperAds getAllAds();

    public Ads createAds(CreateAdsDto createAds);

    public ResponseWrapperAds getAllMyAds(String username);

    public void deleteAds();

    public FullAdsDto getAdsById(Integer id);

    public AdsDTO updateAds(AdsDTO adsDTO);
}

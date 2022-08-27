package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.*;

import java.util.List;

public interface AdsService {

    public ResponseWrapperAds getAllAds();

    public FullAds createAds(CreateAds createAds);

    public ResponseWrapperAds getAllMyAds(String username);

    public FullAds deleteAdsById(Integer id);

    public FullAds getAdsById(Integer id);

    public FullAds updateAds(CreateAds createAds);
}

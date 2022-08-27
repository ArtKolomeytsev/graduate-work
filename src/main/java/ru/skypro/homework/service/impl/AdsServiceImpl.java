package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.dto.ResponseWrapperAds;
import ru.skypro.homework.entities.Ads;
import ru.skypro.homework.entities.User;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.repo.AdsRepo;
import ru.skypro.homework.repo.UserRepo;
import ru.skypro.homework.service.AdsService;

import java.util.List;
import java.util.Optional;

@Service
public class AdsServiceImpl implements AdsService {

    private final AdsRepo adsRepo;
    private final UserRepo userRepo;

    private AdsMapper adsMapper;

    public AdsServiceImpl(AdsRepo adsRepo, UserRepo userRepo) {
        this.adsRepo = adsRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ResponseWrapperAds getAllAds() {
        List<AdsDTO> adsDTO = adsMapper.adsEntityToDtoList(adsRepo.findAll());
        ResponseWrapperAds responseWrapperAds = new ResponseWrapperAds();
        responseWrapperAds.setCount(adsDTO.size());
        responseWrapperAds.setResult(adsDTO);
        return responseWrapperAds;
    }

    @Override
    public FullAds createAds(CreateAds createAds) {
        Ads ads = adsRepo.save(adsMapper.createAdsToEntity(createAds));
        FullAds respons = adsMapper.entityToFullAds(ads);
        return respons;
    }

    @Override
    public ResponseWrapperAds getAllMyAds(String username) {
        User user = userRepo.getUserByUsername(username).get();
        List<AdsDTO> adsDTO = adsMapper.adsEntityToDtoList(adsRepo.findByUserId(user.getId()));
        ResponseWrapperAds responseWrapperAds = new ResponseWrapperAds();
        responseWrapperAds.setCount(adsDTO.size());
        responseWrapperAds.setResult(adsDTO);
        return responseWrapperAds;
    }

    @Override
    public FullAds deleteAdsById(Integer id) {
        Ads ads = adsRepo.findById(id).get();
        if(ads != null){
            adsRepo.deleteById(id);
            FullAds respons = adsMapper.entityToFullAds(ads);
            return respons;
        }
        return null;
    }

    @Override
    public FullAds getAdsById(Integer id) {
        Ads ads = adsRepo.findById(id).get();
        return adsMapper.entityToFullAds(ads);
    }

    @Override
    public FullAds updateAds(CreateAds createAds) {
        return null;
    }
}

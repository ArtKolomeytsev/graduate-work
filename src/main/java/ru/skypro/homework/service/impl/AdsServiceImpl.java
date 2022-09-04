package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Ads;
import ru.skypro.homework.entities.Users;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.repo.AdsRepo;
import ru.skypro.homework.repo.UserRepo;
import ru.skypro.homework.service.AdsService;

import java.time.OffsetDateTime;
import java.util.List;
@Service
public class AdsServiceImpl implements AdsService {

    private final AdsRepo adsRepo;
    private final AdsMapper adsMapper;
    private final UserRepo userRepo;

    public AdsServiceImpl(AdsRepo adsRepo, AdsMapper adsMapper, UserRepo userRepo) {
        this.adsRepo = adsRepo;
        this.adsMapper = adsMapper;
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
    public Ads createAds(CreateAdsDto createAds) {
        Ads ads = adsMapper.createAdsToEntity(createAds);
        ads.setDateMess(OffsetDateTime.now());
        return adsRepo.save(ads);
    }

    @Override
    public ResponseWrapperAds getAllMyAds(String username) {
        Users user = userRepo.findUsersByUsername(username).get();
        List<AdsDTO> adsDTO = adsMapper.adsEntityToDtoList(adsRepo.findByUserId(user.getUserid()));
        ResponseWrapperAds responseWrapperAds = new ResponseWrapperAds();
        responseWrapperAds.setCount(adsDTO.size());
        responseWrapperAds.setResult(adsDTO);
        return responseWrapperAds;
    }

    @Override
    public void deleteAds(Integer id, String username) {
        Users users = userRepo.findUsersByUsername(username).get();
        Ads ads = adsRepo.findById(id).get();
        if (username.equals(users.getUsername())) {
            adsRepo.delete(ads);
        }
    }

    @Override
    public FullAdsDto getAdsById(Integer id) {
        Ads ads = adsRepo.findById(id).get();
        return adsMapper.entityToFullAds(ads);
    }

    @Override
    public AdsDTO updateAds(AdsDTO adsDTO, String username) {
        Users users = userRepo.findUsersByUsername(username).get();
        Ads ads = adsRepo.findById(adsDTO.getPk()).get();
        if (username.equals(users.getUsername())) {
            ads.setDescription(adsDTO.getDescription());
            ads.setPrice(adsDTO.getPrice());
            ads.setTitle(adsDTO.getTitle());
            adsRepo.save(ads);
        }
        return adsDTO;
    }

    @Override
    public Ads findByMessId(Integer id) {
        return adsRepo.findByMessId(id);
    }
}

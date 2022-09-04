package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Ads;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface AdsMapper {

    @Mapping(source = "messId", target = "pk")
    @Mapping(source = "user.userid", target = "author")
    AdsDTO adsEntityToDto(Ads ads);

    Ads createAdsToEntity(CreateAdsDto createAds);

    @Mapping(source = "user.firstName", target = "authorFirstName")
    @Mapping(source = "user.lastName", target = "authorLastName")
    @Mapping(source = "user.phone", target = "phone")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "messId", target = "pk")
    FullAdsDto entityToFullAds(Ads ads);

    List<AdsDTO> adsEntityToDtoList(List<Ads> adsList);
}

package ru.skypro.homework.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Ads;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdsMapper {

    @Mapping(source = "messId", target = "pk")
    @Mapping(source = "user_info.id", target = "author")

    AdsDTO adsEntityToDto(Ads ads);


    Ads createAdsToEntity(CreateAdsDto createAds);

    @Mapping(source = "users_info.firstName", target = "authorFirstName")
    @Mapping(source = "users_info.lastName", target = "authorLastName")
    @Mapping(source = "users_info.phone", target = "phone")
    @Mapping(source = "users_info.email", target = "email")
    @Mapping(source = "messId", target = "pk")

    FullAdsDto entityToFullAds(Ads ads);
    List<AdsDTO> adsEntityToDtoList(List<Ads> adsList);
}

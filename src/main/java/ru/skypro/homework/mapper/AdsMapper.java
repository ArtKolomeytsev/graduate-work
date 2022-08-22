package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Ads;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdsMapper {

    @Mapping(source = "messId", target = "pk")
    @Mapping(source = "user.userId", target = "author")
    AdsDTO adsEntityToDto(Ads ads);

    @Mapping(source = "pk", target = "messId")
    Ads createAdsToEntity(CreateAds createAds);

    @Mapping(source = "user.firstName", target = "authorFirstName")
    @Mapping(source = "user.lastName", target = "authorLastName")
    @Mapping(source = "user.phone", target = "phone")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "messId", target = "pk")
    FullAds entityToFullAds(Ads ads);

    List<AdsDTO> adsEntityToDtoList(List<Ads> adsList);
}
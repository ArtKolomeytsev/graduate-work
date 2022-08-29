package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.AdsComments;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "pk", target = "idComment")
    @Mapping(source = "author", target = "user.id")
    AdsComments DtoToEntity(AdsCommentDto adsCommentDto);

    @Mapping(source = "idComment", target = "pk")
    @Mapping(source = "user.id", target = "author")
    AdsCommentDto EntityToDto(AdsComments adsComments);

    List<AdsCommentDto> commentEntitiesToDtoList (List<AdsComments> adsCommentList);
}

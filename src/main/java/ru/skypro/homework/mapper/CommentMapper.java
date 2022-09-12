package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.AdsComments;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface CommentMapper {

    @Mapping(source = "pk", target = "messages.messId")
    @Mapping(source = "author", target = "user.userId")
    AdsComments DtoToEntity(AdsCommentDto adsCommentDto);

    @Mapping(source = "user.userId", target = "author")
    AdsCommentDto EntityToDto(AdsComments adsComments);

    List<AdsCommentDto> commentEntitiesToDtoList (List<AdsComments> adsCommentList);
}

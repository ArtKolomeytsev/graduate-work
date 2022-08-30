package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.GetImageDto;
import ru.skypro.homework.dto.UploadImageDto;
import ru.skypro.homework.entities.AdvertImages;

@Mapper(componentModel = "spring")
@Service
public interface ImageMapper {

    AdvertImages dtoToEntity(UploadImageDto uploadImageDto);

    GetImageDto modelToDto(GetImageDto getImageDto);
}

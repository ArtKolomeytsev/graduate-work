package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.entities.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    RegisterReq toDTO(User user);

    User toModel(RegisterReq registerReq);
}

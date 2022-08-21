package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import ru.skypro.homework.dto.CreateUser;
import ru.skypro.homework.dto.RegReg;
import ru.skypro.homework.dto.UsersDto;
import ru.skypro.homework.entities.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UsersDto toDTO(User user);

    User toModel(CreateUser createUser, RegReg regReg);

    List<UsersDto> usersToDto(List<User> userList);

}

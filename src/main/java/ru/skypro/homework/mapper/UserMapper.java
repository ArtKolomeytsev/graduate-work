package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import ru.skypro.homework.dto.CreateUserDto;
import ru.skypro.homework.dto.RegReg;
import ru.skypro.homework.dto.UsersDto;
import ru.skypro.homework.entities.UsersInfo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UsersDto toDTO(UsersInfo user);

    UsersInfo toModel(CreateUserDto createUser, RegReg regReg);

    List<UsersDto> usersToDto(List<UsersInfo> userList);

    UsersDto usersEntityToUserDto(UsersInfo user);

}

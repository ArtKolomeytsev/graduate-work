package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import ru.skypro.homework.dto.CreateUserDto;
import ru.skypro.homework.dto.RegReg;
import ru.skypro.homework.dto.UsersDto;
import ru.skypro.homework.entities.Users;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UsersDto toDTO(Users user);

    Users toModel(CreateUserDto createUser, RegReg regReg);

    List<UsersDto> usersToDto(List<Users> userList);

}

package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CreateUserDto;
import ru.skypro.homework.dto.RegReg;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.dto.UsersDto;
import ru.skypro.homework.entities.Users;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface UserMapper {

    UsersDto toDTO(Users user);

    Users toModel(RegisterReq registerReq);

    List<UsersDto> usersToDto(List<Users> userList);

}

package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CreateUser;
import ru.skypro.homework.dto.RegReg;
import ru.skypro.homework.dto.UsersDto;
import ru.skypro.homework.entities.User;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface UserMapper {

    UsersDto toDTO(User user);

    User toModel(CreateUser createUser, RegReg regReg);

    List<UsersDto> usersToDto(List<User> userList);

}

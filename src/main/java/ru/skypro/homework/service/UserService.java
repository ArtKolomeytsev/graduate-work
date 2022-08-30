package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Users;

public interface UserService {

    UsersDto getUser(Integer id);

    UsersDto setPassword(UsersDto usersDto, NewPassword newPassword);

    UsersDto add(CreateUserDto createUser, RegReg regReg);

    ResponseWrapperUser findAllUsers();

    UsersDto updateUser(UsersDto usersDto);

    Users getUserByUsername(String userName);
}

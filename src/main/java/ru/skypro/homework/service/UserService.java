package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;

public interface UserService {

    UsersDto getUser(Integer id);

    UsersDto setPassword(UsersDto usersDto, NewPassword newPassword);

    UsersDto add(CreateUserDto createUser, RegReg regReg);

    ResponseWrapperUser findAllUsers();

    UsersDto updateUser(UsersDto usersDto);
}

package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.User;

public interface UserService {

    UsersDto getUser(Integer id);

    UsersDto setPassword(UsersDto usersDto, NewPassword newPassword);

    UsersDto add(CreateUser createUser, RegReg regReg);

    ResponseWrapperUser findAllUsers();

    UsersDto updateUser(UsersDto usersDto);
}

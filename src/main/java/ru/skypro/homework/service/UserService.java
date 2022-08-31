package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Users;

import java.util.List;

public interface UserService {

    UsersDto getUser(Integer id);

    UsersDto setPassword(UsersDto usersDto, NewPassword newPassword);

    UsersDto add(RegisterReq createUser);

    UsersDto update(RegisterReq updateUser);

    UsersDto deleteUserById(Integer id);

    UsersDto deleteUserByUsername(String userName);

    ResponseWrapperUser findAllUsers();

    UsersDto getUserByUsername(String userName);

    List<UsersDto>  getUserAll();
}

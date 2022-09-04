package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Users;

import java.util.List;

public interface UserService {

    UsersDto getUser(Integer id);

    UsersDto setPassword(UsersDto usersDto, NewPassword newPassword);

    Users add(Users users);

    UsersDto update(RegisterReq updateUser);

    UsersDto deleteUserById(Integer id);

    UsersDto deleteUserByUsername(String userName);

    ResponseWrapperUser findAllUsers();

    Users getUserByUsername(String userName);

    List<UsersDto>  getUserAll();
}

package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.User;

public interface UserService {

    User getUser(LoginReq loginReq);

    User add(RegisterReq registerReq);
}

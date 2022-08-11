package ru.skypro.homework.interfaces;

import ru.skypro.homework.dto.LoginReq;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.entities.User;

public interface IUserService {
    User getUser(LoginReq loginReq);
    User add(RegisterReq registerReq);
}

package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.LoginReq;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.entities.User;
import ru.skypro.homework.repo.UserRepo;
import ru.skypro.homework.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUser(LoginReq loginReq) {
        return null;
    }

    @Override
    public User add(RegisterReq registerReq) {
        User user = new User(registerReq);
        return userRepo.save(user);
    }
}

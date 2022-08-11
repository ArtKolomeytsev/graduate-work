package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.LoginReq;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.entities.User;
import ru.skypro.homework.interfaces.IUserService;
import ru.skypro.homework.repository.IUserRepository;

@Service
public class UserServices implements IUserService {
    private final IUserRepository repository;

    public UserServices(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUser(LoginReq loginReq) {
        return null;
    }

    @Override
    public User add(RegisterReq registerReq) {
        User userAdd = new User(registerReq);
        return repository.save(userAdd);
    }
}

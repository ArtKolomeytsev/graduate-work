package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.entities.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.service.impl.UserServiceImpl;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/add")
    public User add(@RequestBody  RegisterReq registerReq) {
        return null;
    }

}

package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
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
    public ResponseEntity<UsersDto> add(@RequestBody  CreateUser createUser, @RequestBody RegReg regReg) {
        UsersDto usersDto = userService.add(createUser, regReg);
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping(path = "/me")
    public ResponseEntity<ResponseWrapperUser> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PatchMapping(path = "/me")
    public ResponseEntity<UsersDto> updateUser(UsersDto usersDto) {
        return ResponseEntity.ok(userService.updateUser(usersDto));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsersDto> getUser(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

}

package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Users;
import ru.skypro.homework.service.impl.UserServiceImpl;


@Validated
@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public ResponseWrapperUser getAll() {
        return userService.findAllUsers();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/me")
    public ResponseEntity<Users> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.getUserByUsername(authentication.getName());
        return ResponseEntity.ok(user);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PutMapping(path = "/update")
    public ResponseEntity<UsersDto> updateUser(@RequestBody RegisterReq createUser) {
        UsersDto usersDto = userService.update(createUser);
        return ResponseEntity.ok(usersDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<UsersDto> getUser(@PathVariable Integer id) {
        UsersDto usersDto = userService.getUser(id);
        return ResponseEntity.ok(usersDto);

    }
}

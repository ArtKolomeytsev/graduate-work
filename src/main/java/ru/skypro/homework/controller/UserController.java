package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<UsersDto>> getAll() {
        List<UsersDto> usersDto = userService.getUserAll();
        if (usersDto.size() != 0) {
            return ResponseEntity.ok(usersDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
/*
    @PostMapping(path = "/add")
    public ResponseEntity<UsersDto> add(@RequestBody RegisterReq createUser) {
        UsersDto usersDto = userService.add(createUser);
        if(usersDto == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(usersDto);
    }

 */

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<UsersDto> deleteById(@PathVariable Integer id){
        UsersDto usersDto = userService.deleteUserById(id);
        if(usersDto == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(usersDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @DeleteMapping(path = "/deleteByUsername/{userName}")
    public ResponseEntity<UsersDto> deleteByUsername(@PathVariable String userName){
        UsersDto usersDto = userService.deleteUserByUsername(userName);
        if(usersDto == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(usersDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/me")
    public ResponseEntity<ResponseWrapperUser> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PutMapping(path = "/update")
    public ResponseEntity<UsersDto> updateUser(@RequestBody RegisterReq createUser) {
        UsersDto usersDto = userService.update(createUser);
        if (usersDto != null) {
            return ResponseEntity.ok(usersDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<UsersDto> getUser(@PathVariable Integer id) {
        UsersDto usersDto = userService.getUser(id);
        if (usersDto != null) {
            return ResponseEntity.ok(usersDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "getUserByUsername/{username}")
    public ResponseEntity<UsersDto> getUserByUsername(@PathVariable String username) {
        UsersDto usersDto = userService.getUserDtoByUsername(username);
        if (usersDto != null) {
            return ResponseEntity.ok(usersDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}

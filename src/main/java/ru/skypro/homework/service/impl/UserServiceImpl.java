package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Users;
import ru.skypro.homework.exceprion.UserNotFoundException;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repo.UserRepo;
import ru.skypro.homework.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }


    @Override
    public Users add(Users users) {
        Users user = userRepo.findUsersByUsername(users.getUsername()).orElseThrow(UserNotFoundException::new);
        user.setFirstName(users.getFirstName());
        user.setLastName(users.getLastName());
        user.setPhone(users.getPhone());
        userRepo.save(user);
        return user;
    }

    @Override
    public UsersDto update(RegisterReq updateUser) {
        Users user = userMapper.toModel(updateUser);
        userRepo.save(user);
        return userMapper.toDTO(user);
    }


    @Override
    public UsersDto getUser(Integer id) {
        Users user = userRepo.findById(id).orElseThrow(UserNotFoundException::new);
        return userMapper.toDTO(user);
    }

    @Override
    public UsersDto setPassword(UsersDto usersDto, NewPassword newPassword) {
        Users user = userRepo.findById(usersDto.getId()).orElseThrow(UserNotFoundException::new);
        user.setPassword(newPassword.getNewPassword());
        return usersDto;
    }

    @Override
    public ResponseWrapperUser findAllUsers() {
        List<UsersDto> usersDtoList = userMapper.usersToDto(userRepo.findAllByOrderByUserId());
        ResponseWrapperUser responseWrapperUser = new ResponseWrapperUser();
        responseWrapperUser.setCount(usersDtoList.size());
        responseWrapperUser.setResult(usersDtoList);
        return responseWrapperUser;

    }

    @Override
    public Users getUserByUsername(String userName) {
        return userRepo.findUsersByUsername(userName).orElseThrow(UserNotFoundException::new);
    }
}
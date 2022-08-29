package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.UsersInfo;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repo.UserRepo;
import ru.skypro.homework.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UsersDto add(CreateUserDto createUser, RegReg regReg) {
        UsersInfo user = userMapper.toModel(createUser, regReg);
        userRepo.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UsersDto getUser(Integer id) {
        UsersInfo user = userRepo.findById(id).get();
        return userMapper.toDTO(user);
    }

    @Override
    public UsersDto setPassword(UsersDto usersDto, NewPassword newPassword) {
        UsersInfo user = userRepo.findById(usersDto.getId()).get();
        user.setPassword(newPassword.getNewPassword());
        return usersDto;
    }

    @Override
    public ResponseWrapperUser findAllUsers() {
        List<UsersDto> usersDtoList = userMapper.usersToDto(userRepo.findAllUsers());
        ResponseWrapperUser responseWrapperUser = new ResponseWrapperUser();
        responseWrapperUser.setCount(usersDtoList.size());
        responseWrapperUser.setResult(usersDtoList);
        return responseWrapperUser;

    }

    @Override
    public UsersDto updateUser(UsersDto usersDto) {
        UsersInfo user = userRepo.findById(usersDto.getId()).get();
        user.setFirstName(usersDto.getFirstName());
        user.setLastName(usersDto.getLastName());
        user.setUsername(usersDto.getUsername());
        user.setPhone(usersDto.getPhone());
        user.setEmail(usersDto.getEmail());
        userRepo.save(user);
        return usersDto;
    }
}

package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.Users;
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
    public UsersDto add(Users users) {
        userRepo.save(users);
        return userMapper.toDTO(users);
    }

    @Override
    public UsersDto update(RegisterReq updateUser) {
        Users user = userMapper.toModel(updateUser);
        userRepo.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UsersDto deleteUserById(Integer id) {
        Users user = userRepo.findUsersByUserid(id);
        if(user == null){
            return null;
        }else {
            try {
                userRepo.deleteUsersByUserid(id);
                return userMapper.toDTO(user);
            }catch (Exception exception){
                return null;
            }
        }
    }

    @Override
    public UsersDto deleteUserByUsername(String userName) {
        Users user = userRepo.findUsersByUsername(userName);
        if(user == null){
            return null;
        }else {
            try {
                userRepo.deleteUsersByUserid(user.getUserid());
                return userMapper.toDTO(user);
            }catch (Exception exception){
                return null;
            }
        }
    }

    @Override
    public UsersDto getUser(Integer id) {
        Users user = userRepo.findById(id).get();
        return userMapper.toDTO(user);
    }

    @Override
    public UsersDto setPassword(UsersDto usersDto, NewPassword newPassword) {
        Users user = userRepo.findById(usersDto.getId()).get();
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
    public UsersDto getUserDtoByUsername(String userName) {
        return userMapper.toDTO(userRepo.getUserByUsername(userName));
    }

    @Override
    public Users getUserByUsername(String userName) {
        return userRepo.getUserByUsername(userName);
    }

    @Override
    public List<UsersDto> getUserAll() {
        List<Users> usersList = userRepo.findAllUsers();
        return userMapper.usersToDto(usersList);
    }
}

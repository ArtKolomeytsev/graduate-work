package ru.skypro.homework.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CreateUserDto;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.dto.RoleDto;
import ru.skypro.homework.dto.UsersDto;
import ru.skypro.homework.entities.Users;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserDetailsManager manager;
    private final UserServiceImpl userService;
    private final PasswordEncoder encoder;

    private final UserMapper userMapper;

    public AuthServiceImpl(UserDetailsManager manager, UserServiceImpl userService, UserMapper userMapper) {
        this.manager = manager;
        this.userMapper = userMapper;
        this.encoder = new BCryptPasswordEncoder();
        this.userService = userService;
    }

    @Override
    public boolean login(String userName, String password) {
        if (!manager.userExists(userName)) {
            return false;
        }
        UserDetails userDetails = manager.loadUserByUsername(userName);
        String encryptedPassword = userDetails.getPassword();
        String encryptedPasswordWithoutEncryptionType = encryptedPassword.substring(8);
        return encoder.matches(password, encryptedPasswordWithoutEncryptionType);
    }

    @Override
    public boolean register(RegisterReq registerReq, RoleDto role) {
        if (manager.userExists(registerReq.getUsername())) {
            return false;
        }
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .password(registerReq.getPassword())
                        .username(registerReq.getUsername())
                        .roles(role.name())
                        .build()
        );
        Users savedUser = userService.getUserByUsername(registerReq.getUsername());
        savedUser.setFirstName(registerReq.getFirstName());
        savedUser.setLastName(registerReq.getLastName());
        savedUser.setPhone(registerReq.getPhone());
        savedUser.setEmail(registerReq.getUsername());
        this.userService.add(savedUser);
        return true;

    }
}

package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    User findUserByUsername(LoginReq loginReq);
    User save(User user);
}

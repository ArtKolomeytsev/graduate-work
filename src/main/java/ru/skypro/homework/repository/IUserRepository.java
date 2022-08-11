package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entities.User;

public interface IUserRepository extends JpaRepository<User,String> {
    User findUserByUsername(User user);
    User save(User user);
}

package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "select * from users order by userId",nativeQuery = true)
    List<User> findAllUsers();

    Optional<User> getUserByUsername(String username);
}

package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entities.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    @Query(value = "select * from users order by userId",nativeQuery = true)
    List<Users> findAllUsers();

    Users findUsersByUserid(Integer id);
    Optional<Users> findUsersByUsername(String username);
    void deleteUsersByUserid(Integer id);
}

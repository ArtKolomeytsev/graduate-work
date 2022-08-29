package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entities.UsersInfo;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UsersInfo, Integer> {

    @Query(value = "select * from users_info order by id",nativeQuery = true)
    List<UsersInfo> findAllUsers();

    Optional<UsersInfo> getUserByUsername(String username);
}

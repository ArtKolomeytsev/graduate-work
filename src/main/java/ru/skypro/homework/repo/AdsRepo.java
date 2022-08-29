package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.homework.entities.Ads;

import java.util.List;

public interface AdsRepo extends JpaRepository<Ads, Integer> {
    @Query(value = "select * from ads order by messId", nativeQuery = true)
    List<Ads> findAll();

    @Query(value = "select * from ads where Ads.users_id = ?1", nativeQuery = true)
    List<Ads> findByUserId(Integer author);
}

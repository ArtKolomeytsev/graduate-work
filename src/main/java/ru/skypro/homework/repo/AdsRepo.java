package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.homework.entities.Ads;

import java.util.List;
import java.util.Optional;

public interface AdsRepo extends JpaRepository<Ads, Integer> {

    List<Ads> findAll();

    List<Ads> findAllByUserUserId(Integer author);

    Optional<Ads> findByMessId(Integer id);
}

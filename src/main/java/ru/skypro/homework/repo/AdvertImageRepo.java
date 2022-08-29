package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entities.AdvertImages;

import java.util.Optional;

@Repository
public interface AdvertImageRepo extends JpaRepository<AdvertImages, Integer> {


    Optional<AdvertImages> findById(Integer id);

}

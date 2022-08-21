package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entities.Ads;

public interface AdsRepo extends JpaRepository<Ads, Integer> {
}

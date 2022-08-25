
package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.homework.entities.Ads;
import ru.skypro.homework.entities.AdsComments;

import java.util.List;

public interface AdsCommentRepo extends JpaRepository<AdsComments, Integer> {
    @Query(value = "select * from ads order by comment_id", nativeQuery = true)
    List<AdsComments> findAll();
}


package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.homework.entities.AdsComments;

import java.util.List;

public interface AdsCommentRepo extends JpaRepository<AdsComments, Integer> {
    List<AdsComments> findAllByMessIdOrderByDateTimeDesc(Integer id);

    AdsComments getByIdComment(Integer id);
}

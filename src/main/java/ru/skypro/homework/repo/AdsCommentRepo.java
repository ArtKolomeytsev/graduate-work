
package ru.skypro.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entities.AdsComments;

import java.util.List;
import java.util.Optional;

public interface AdsCommentRepo extends JpaRepository<AdsComments, Integer> {
    List<AdsComments> findAllByMessagesMessIdOrderByDateTimeDesc(Integer id);

    Optional<AdsComments> getByIdComment(Integer id);
}

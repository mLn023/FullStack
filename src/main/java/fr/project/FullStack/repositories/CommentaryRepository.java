package fr.project.FullStack.repositories;

import fr.project.FullStack.model.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CommentaryRepository extends JpaRepository<Commentary, Integer> {
    Optional<Commentary> findById(Integer id);
    List<Commentary> findAllBybugId(Integer bug_id);
    List<Commentary> findAllByDeveloppeurId(Integer dev_id);
}

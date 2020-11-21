package fr.project.FullStack.repositories;

import fr.project.FullStack.model.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public interface CommentaryRepository extends JpaRepository<Commentary, Integer> {
    Optional<Commentary> findById(Integer id);
}

package fr.project.FullStack.repositories;


import fr.project.FullStack.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BugRepository extends JpaRepository<Bug, Integer>{

    Optional<Bug> findById(Integer id);
}

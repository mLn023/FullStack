package fr.project.FullStack.repositories;

import fr.project.FullStack.model.Developpeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloppeurRepository extends JpaRepository<Developpeur,Integer>{
    Optional<Developpeur> findById(Integer id);
}

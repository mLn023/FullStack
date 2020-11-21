package fr.project.FullStack.repositories;

import fr.project.FullStack.model.Developpeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloppeurRepository extends JpaRepository<Developpeur,Integer>{
    Optional<Developpeur> findById(Integer id);
}

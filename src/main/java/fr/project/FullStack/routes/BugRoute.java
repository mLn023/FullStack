package fr.project.FullStack.routes;

import fr.project.FullStack.exception.RessourceNotFoundException;
import fr.project.FullStack.model.Bug;
import fr.project.FullStack.model.Commentary;
import fr.project.FullStack.model.CreateBug;
import fr.project.FullStack.model.Developpeur;
import fr.project.FullStack.repositories.BugRepository;
import fr.project.FullStack.repositories.CommentaryRepository;
import fr.project.FullStack.repositories.DeveloppeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BugRoute {

    @Autowired
    BugRepository bugRepository;


    @Autowired
    DeveloppeurRepository developpeurRepository;

    @GetMapping("/bugs/{id}")
    public Bug getBug(@PathVariable("id") Integer id) {
        return bugRepository.findById(id).orElse(null);
    }

    @GetMapping("/bugs")
    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    @PostMapping("/bugs")
    public Bug createBug(@Validated @RequestBody CreateBug nouveauBug) {


        return bugRepository.save(Bug
                .builder()
                .name(nouveauBug.getName())
                .description(nouveauBug.getDescription())
                .priority(nouveauBug.getPriority())
                .status(1)
                .created_at(nouveauBug.getCreated_at())
                .developpeur(developpeurRepository.findById(nouveauBug.getDeveloppeur_id()).get())
                .build());
    }

    @PutMapping("bugs/{id}")
    public Bug UpdateBug(@PathVariable("id") Integer id, @Validated @RequestBody CreateBug bug){


        if(!bugRepository.existsById(id)){
            //exception a faire
            return null;
        }

        return bugRepository.findById(id)
                .map(updatebug ->{
                    updatebug.setName(bug.getName());
                    updatebug.setDescription(bug.getDescription());
                    updatebug.setPriority(bug.getPriority());
                    updatebug.setStatus(bug.getStatus());
                    updatebug.setDeveloppeur(developpeurRepository.findById(bug.getDeveloppeur_id()).get());
                    return bugRepository.save(updatebug);
                }).orElse(null);
    }

    @DeleteMapping("/bugs/{id}")
        public ResponseEntity<?> deleteBug(@PathVariable("id") Integer id){
        if(!bugRepository.existsById(id)) {
            throw new RessourceNotFoundException("Bug not found with id " + id);
        }

        return bugRepository.findById(id)
                .map(bug -> {
                    bugRepository.delete(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new RessourceNotFoundException("Bug not found with Id" + id));
    }

}
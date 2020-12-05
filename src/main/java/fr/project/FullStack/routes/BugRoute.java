package fr.project.FullStack.routes;

import fr.project.FullStack.exception.RessourceNotFoundException;
import fr.project.FullStack.model.Bug;
import fr.project.FullStack.model.Commentary;
import fr.project.FullStack.model.CreateBug;
import fr.project.FullStack.repositories.BugRepository;
import fr.project.FullStack.repositories.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BugRoute {

    @Autowired
    BugRepository bugRepository;

    @Autowired
    CommentaryRepository commentaryRepository;

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
                .status("TODO")
                .created_at(nouveauBug.getCreated_at())
                .build());
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
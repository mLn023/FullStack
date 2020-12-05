package fr.project.FullStack.routes;

import fr.project.FullStack.exception.RessourceNotFoundException;
import fr.project.FullStack.model.Bug;
import fr.project.FullStack.model.Commentary;
import fr.project.FullStack.model.Developpeur;
import fr.project.FullStack.repositories.BugRepository;
import fr.project.FullStack.repositories.CommentaryRepository;
import fr.project.FullStack.repositories.DeveloppeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentaryRoute {

    @Autowired
    BugRepository bugRepository;

    @Autowired
    CommentaryRepository commentaryRepository;

    @Autowired
    DeveloppeurRepository developpeurRepository;

    @GetMapping("/commentary/{id}")
    public Optional<Commentary> getCommentary(@PathVariable("id") Integer id) {
        return commentaryRepository.findById(id);
    }

    @GetMapping("/devs/{developpeur_id}/commentaries")
    public List<Commentary> getAllCommentariesByDevId(@PathVariable("developpeur_id") Integer dev_id) {
        if (!developpeurRepository.existsById(dev_id)) {
            return null;
        }

        return commentaryRepository.findAllByDeveloppeurId(dev_id);
    }

    @GetMapping("/bugs/{bug_id}/commentaries")
    public List<Commentary> getAllCommentariesByBugId(@PathVariable("bug_id") Integer bug_id) {
        if (!bugRepository.existsById(bug_id)) {
            return null;
        }

        return commentaryRepository.findAllBybugId(bug_id);

    }

    @DeleteMapping("/commentary/{id}")
    public ResponseEntity<?> deleteCommentary(@PathVariable("id") Integer id ){
        if(!commentaryRepository.existsById(id)) {
            throw new RessourceNotFoundException("Commentary not found with id " + id);
        }

        return commentaryRepository.findById(id)
                .map(commentary -> {
                    commentaryRepository.delete(commentary);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()->new RessourceNotFoundException("Commentary not found with Id" + id));
    }
    }


package fr.project.FullStack;

import fr.project.FullStack.model.CreateDeveloppeur;
import fr.project.FullStack.model.Developpeur;
import fr.project.FullStack.repositories.DeveloppeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DeveloppeursRoute {

    @Autowired
    DeveloppeurRepository DeveloppeurRepository;

    @GetMapping("devs/{id}")
    public Developpeur getDeveloppeur(@PathVariable("id") Integer id){
        return DeveloppeurRepository.findById(id).orElse(null);

    }

    @GetMapping("devs")
    public List<Developpeur> getAllDevs(){
        return DeveloppeurRepository.findAll();
    }
/**
    @PostMapping("devs")
    public Developpeur createDeveloppeur(@Validated @RequestBody CreateDeveloppeur devs){
        return DeveloppeurRepository.save(
                devs
                .builder()
                .nom(devs.getName())
                .firstName(devs.getFirstname())
                .build()
        );
    }
    **/
}

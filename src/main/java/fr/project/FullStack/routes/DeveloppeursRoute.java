package fr.project.FullStack.routes;

import fr.project.FullStack.model.CreateDeveloppeur;
import fr.project.FullStack.model.Developpeur;
import fr.project.FullStack.repositories.DeveloppeurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeveloppeursRoute {

    @Autowired
    DeveloppeurRepository DeveloppeurRepository;

    @GetMapping("/devs/{id}")
    public Developpeur getDeveloppeur(@PathVariable("id") Integer id) {
        return DeveloppeurRepository.findById(id).orElse(null);

    }

    @GetMapping("/devs")
    public List<Developpeur> getAllDevs() {
        return DeveloppeurRepository.findAll();
    }

    @PostMapping("/devs")
    public Developpeur CreateDeveloppeur (@Validated @RequestBody CreateDeveloppeur nouveauDev){
        return DeveloppeurRepository.save(Developpeur
        .builder()
                .name(nouveauDev.getName())
                .firstname(nouveauDev.getFirstname())
                .function(nouveauDev.getFunction())
                .build());
    }

    @PutMapping(value = "/devs/{id}",consumes = {"application/json"})
    public Developpeur updateDeveloppeur(@PathVariable("id") Integer id, @Validated @RequestBody Developpeur devs)
    {
        if(!DeveloppeurRepository.existsById(id)){
            //exception a faire
            return null;
        }

        return DeveloppeurRepository.findById(id)
                .map(developpeur -> {
                developpeur.setName(devs.getName());
                developpeur.setFirstname(devs.getFirstname());
                developpeur.setFunction(devs.getFunction());
                return DeveloppeurRepository.save(developpeur);}).orElse(null);
    }
}

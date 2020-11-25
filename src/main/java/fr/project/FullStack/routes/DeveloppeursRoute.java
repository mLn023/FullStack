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
    DeveloppeurRepository developpeurRepository;

    @GetMapping("/devs/{id}")
    public Developpeur getDeveloppeur(@PathVariable("id") Integer id) {
        return developpeurRepository.findById(id).orElse(null);

    }

    @GetMapping("/devs")
    public List<Developpeur> getAllDevs() {
        return developpeurRepository.findAll();
    }

    @PostMapping("/devs")
    public Developpeur CreateDeveloppeur (@Validated @RequestBody CreateDeveloppeur nouveauDev){
        return developpeurRepository.save(Developpeur
        .builder()
                .name(nouveauDev.getName())
                .firstname(nouveauDev.getFirstname())
                .function(nouveauDev.getFunction())
                .build());
    }

    @PutMapping(value = "/devs/{id}")
    public Developpeur updateDeveloppeur(@PathVariable("id") Integer id, @Validated @RequestBody Developpeur devs)
    {
        if(!developpeurRepository.existsById(id)){
            //exception a faire
            return null;
        }

        return developpeurRepository.findById(id)
                .map(developpeur -> {
                developpeur.setName(devs.getName());
                developpeur.setFirstname(devs.getFirstname());
                developpeur.setFunction(devs.getFunction());
                return developpeurRepository.save(developpeur);}).orElse(null);
    }
}

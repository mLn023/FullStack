package fr.project.FullStack.routes;

import fr.project.FullStack.model.CreateDeveloppeur;
import fr.project.FullStack.model.Developpeur;
import fr.project.FullStack.repositories.DeveloppeurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
                .build());
    }
}

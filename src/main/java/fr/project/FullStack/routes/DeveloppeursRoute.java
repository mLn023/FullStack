package fr.project.FullStack.routes;

import fr.project.FullStack.exception.RessourceNotFoundException;
import fr.project.FullStack.model.CreateDeveloppeur;
import fr.project.FullStack.model.Developpeur;
import fr.project.FullStack.repositories.DeveloppeurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Developpeur CreateDeveloppeur (@Validated @RequestBody CreateDeveloppeur nouveauDev) throws IOException{

        return developpeurRepository.save(Developpeur
        .builder()
                .name(nouveauDev.getName())
                .firstname(nouveauDev.getFirstname())
                .function(nouveauDev.getFunction())
                .build());
    }


    @PutMapping("/devs/{id}")
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
                //developpeur.setProfilePic(devs.getProfilePic());
                return developpeurRepository.save(developpeur);}).orElse(null);
    }

    @DeleteMapping("/devs/{id}")
    public ResponseEntity<?> deleteDeveloppeur(@PathVariable("id") Integer id ){
        if(!developpeurRepository.existsById(id)) {
            throw new RessourceNotFoundException("Developpeur not found with id " + id);
        }
        return developpeurRepository.findById(id)
                .map(developpeur -> {
                    developpeurRepository.delete(developpeur);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()->new RessourceNotFoundException("Developpeur not found with id" + id));
    }
}

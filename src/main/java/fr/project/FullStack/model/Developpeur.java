package fr.project.FullStack.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Developpeur")
public class Developpeur {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String firstname;
    private String function;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "developpeur", orphanRemoval = true)
    @JsonIgnoreProperties({"listebugs","listecoms"})
    private List<Bug> listebugs;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "developpeur", orphanRemoval = true)
    @JsonIgnoreProperties("coms")
    private List<Commentary> listecoms;



}

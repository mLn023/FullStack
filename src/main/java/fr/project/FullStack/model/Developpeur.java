package fr.project.FullStack.model;


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
    private int id;
    private String name;
    private String firstname;
    private String function;

    @OneToMany(mappedBy = "developpeur")
    @JsonManagedReference
    private List<Bug> listebugs;

    @OneToMany(mappedBy = "developpeur")
    @JsonManagedReference
    private List<Commentary> listecoms;


}

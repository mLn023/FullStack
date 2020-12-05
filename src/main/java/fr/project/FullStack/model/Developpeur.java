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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "developpeur")
    @JsonManagedReference("bugs")
    private List<Bug> listebugs;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "developpeur")
    @JsonManagedReference("coms")
    private List<Commentary> listecoms;


}

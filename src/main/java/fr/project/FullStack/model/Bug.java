package fr.project.FullStack.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Bug")
public class Bug {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String status;

    @ManyToMany
    @JoinTable(
            name ="bug_devs",
            joinColumns = @JoinColumn(name="developpeur_id"),
            inverseJoinColumns = @JoinColumn(name = "bug_id")
    )
    private Set<Developpeur> devs;


}

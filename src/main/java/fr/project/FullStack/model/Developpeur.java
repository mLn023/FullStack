package fr.project.FullStack.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Developpeur")
public class Developpeur {
    @ManyToMany(mappedBy = "gererbug")
    Set<Bug> bugs;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String firstName;



}

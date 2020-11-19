package fr.project.FullStack.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Developpeur")
public class Developpeur {
    @ManyToOne
    @JoinColumn(name="developpeur_id", nullable= true)
    private Developpeur developpeur;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String firstName;



}

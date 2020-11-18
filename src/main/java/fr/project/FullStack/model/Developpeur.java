package fr.project.FullStack.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder

@Entity
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

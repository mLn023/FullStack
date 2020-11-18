package fr.project.FullStack.model;

import com.sun.istack.NotNull;

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
@Builder

@Entity
@Table(name="Bug")
public class Bug {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String status;

    @OneToMany (mappedBy = "Developpeur")
    private Set<Bug> Bugs;


}

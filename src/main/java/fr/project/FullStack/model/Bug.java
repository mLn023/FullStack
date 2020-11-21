package fr.project.FullStack.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private String description;
    private String priority;
    private String status;
    private String created_at;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="developpeur_id")
    private Developpeur developpeur;

    @OneToMany(mappedBy = "bug")
    @JsonManagedReference
    private List<Commentary> listecoms;

}

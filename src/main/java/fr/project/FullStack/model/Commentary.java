package fr.project.FullStack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Commentary")
public class Commentary {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String description;
    //@Temporal(TemporalType.DATE)
    private String created_at;

    @ManyToOne
    @JsonBackReference
    private Developpeur developpeur;
    @ManyToOne
    @JsonBackReference
    private Bug bug;
}

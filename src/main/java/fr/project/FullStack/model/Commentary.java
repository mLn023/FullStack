package fr.project.FullStack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created_at;

    @ManyToOne
    @JsonIgnoreProperties({"listebugs","listecoms" })
    private Developpeur developpeur;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"developper", "listecoms"})
    private Bug bug;
}

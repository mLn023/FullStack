package fr.project.FullStack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBug {
    private String name;
    private String priority;
    private int status;
    private String description;
    private Date created_at;
    private Integer developpeur_id;
}

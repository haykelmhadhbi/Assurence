package tn.esprit.assurence.entites;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idContrat;
    private String matricule ;
    @Temporal(TemporalType.DATE)
    private Date dateEffet ;
    @Enumerated(EnumType.STRING)
    private TypeContrat type;
}




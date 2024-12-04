package tn.esprit.assurence.entites;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idAssurance;
    private String designation;
    private float montant;
    @ManyToOne
    private Beneficiaire beneficiaire;
    @ManyToOne
    private Contrat contrat;

}

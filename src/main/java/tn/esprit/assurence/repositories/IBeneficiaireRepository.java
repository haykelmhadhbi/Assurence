package tn.esprit.assurence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.assurence.entites.Beneficiaire;

public interface IBeneficiaireRepository extends JpaRepository<Beneficiaire,Integer> {
}

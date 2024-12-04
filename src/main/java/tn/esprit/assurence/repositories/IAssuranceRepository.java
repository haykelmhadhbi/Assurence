package tn.esprit.assurence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.assurence.entites.Assurance;

public interface IAssuranceRepository extends JpaRepository< Assurance, Integer> {
}

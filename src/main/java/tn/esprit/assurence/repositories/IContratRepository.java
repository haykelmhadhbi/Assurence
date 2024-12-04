package tn.esprit.assurence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.assurence.entites.Contrat;

public interface IContratRepository extends JpaRepository<Contrat,Integer> {
}

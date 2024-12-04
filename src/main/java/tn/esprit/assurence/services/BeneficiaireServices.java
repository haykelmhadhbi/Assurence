package tn.esprit.assurence.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.assurence.entites.Beneficiaire;
import tn.esprit.assurence.iservices.IntBeneficiaireServices;
import tn.esprit.assurence.repositories.IBeneficiaireRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class BeneficiaireServices implements IntBeneficiaireServices {
    public final IBeneficiaireRepository benefRepository;

    @Override
    public int ajouterBeneficaire(Beneficiaire bf) {
        try {
            // Sauvegarder le bénéficiaire dans la base de données
            Beneficiaire savedBeneficiaire = benefRepository.save(bf);

            // Afficher le CIN du bénéficiaire ajouté
            System.out.println("Cin: " + savedBeneficiaire.getCin());

            // Si l'enregistrement est réussi, retourner 1
            return savedBeneficiaire.getCin() > 0 ? 1 : 0;
        } catch (Exception e) {
            // Gérer l'exception et retourner 0 en cas d'échec
            System.out.println("Erreur lors de l'ajout du bénéficiaire: " + e.getMessage());
            return 0;
        }
    }

}

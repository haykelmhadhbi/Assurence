package tn.esprit.assurence.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.assurence.entites.Assurance;
import tn.esprit.assurence.entites.Beneficiaire;
import tn.esprit.assurence.entites.Contrat;
import tn.esprit.assurence.iservices.IntAssurenceServices;
import tn.esprit.assurence.repositories.IAssuranceRepository;
import tn.esprit.assurence.repositories.IBeneficiaireRepository;
import tn.esprit.assurence.repositories.IContratRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class AssurenceServices implements IntAssurenceServices {

    private  final IAssuranceRepository iAssuranceRepository;
    private  final IBeneficiaireRepository iBeneficiaireRepository;

    private  final IContratRepository contratRepository;


    @Transactional
    @Override
    public int ajouterAssurance(Assurance a, int cinBf) {
        // Recherche du bénéficiaire par CIN
        Beneficiaire beneficiaire = iBeneficiaireRepository.getByCin(cinBf);
        if (beneficiaire == null) {
            // Si le bénéficiaire n'est pas trouvé, retourner 0 pour indiquer une erreur
            return 0;
        }

        // Affecter le bénéficiaire à l'assurance
        a.setBeneficiaire(beneficiaire);

        // Vérifier si un contrat est déjà présent pour l'assurance
        Contrat contrat = a.getContrat();
        if (contrat == null) {
            // Si le contrat est null, vous pouvez soit en créer un nouveau, soit retourner une erreur
            contrat = new Contrat();
            a.setContrat(contrat);
        }

        // Sauvegarder le contrat si nécessaire
        contrat = contratRepository.save(contrat);
        a.setContrat(contrat);  // Assurez-vous que l'assurance soit bien liée au contrat

        // Sauvegarder l'assurance
        Assurance savedAssurance = iAssuranceRepository.save(a);

        // Retourner l'ID de l'assurance sauvegardée
        return savedAssurance.getIdAssurance();
    }



}

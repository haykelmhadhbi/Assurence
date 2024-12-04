package tn.esprit.assurence.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.assurence.entites.Beneficiaire;
import tn.esprit.assurence.services.BeneficiaireServices;

@RestController
@RequestMapping("/beneficiaire")
@RequiredArgsConstructor

public class BeneficiaireRestController {
    private final BeneficiaireServices beneficiaireServices;

    @PostMapping("/ajouter")
    public ResponseEntity<String> ajouterBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        int result = beneficiaireServices.ajouterBeneficaire(beneficiaire);

        if (result == 1) {
            return ResponseEntity.ok("Bénéficiaire ajouté avec succès !");
        } else {
            return ResponseEntity.status(500).body("Échec de l'ajout du bénéficiaire.");
        }
    }
}

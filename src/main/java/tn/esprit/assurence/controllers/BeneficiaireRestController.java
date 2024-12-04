package tn.esprit.assurence.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.assurence.entites.Assurance;
import tn.esprit.assurence.entites.Beneficiaire;
import tn.esprit.assurence.services.AssurenceServices;
import tn.esprit.assurence.services.BeneficiaireServices;

@RestController
@RequestMapping("/beneficiaire")
@RequiredArgsConstructor

public class BeneficiaireRestController {
    private final BeneficiaireServices beneficiaireServices;
    private  final AssurenceServices assurenceServices;

    @PostMapping("/ajouter")
    public ResponseEntity<String> ajouterBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        int result = beneficiaireServices.ajouterBeneficaire(beneficiaire);

        if (result == 1) {
            return ResponseEntity.ok("Bénéficiaire ajouté avec succès !");
        } else {
            return ResponseEntity.status(500).body("Échec de l'ajout du bénéficiaire.");
        }
    }

    @PostMapping("/ajouterAssurence/{cinBf}")
    public ResponseEntity<Integer> ajouterAssurance(
            @RequestBody Assurance a,
            @PathVariable int cinBf) {
        int idAssurance = assurenceServices.ajouterAssurance(a, cinBf);
        return ResponseEntity.ok(idAssurance);
    }
}

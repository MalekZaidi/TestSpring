package com.example.demo.Controllers;
import com.example.demo.entities.Assurance;
import com.example.demo.entities.Beneficiare;
import com.example.demo.entities.Contrat;
import com.example.demo.entities.TypeContrat;
import com.example.demo.services.iAssuranceService;
import com.example.demo.services.iBeneficiareService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/assurance")
@RequiredArgsConstructor
public class AssuranceRestController {

    private final iAssuranceService assuranceServices;

    @PostMapping("/add")
    public Assurance addAssurance (@RequestBody Assurance a,
                                   @RequestParam("cin") int cinbf,
                                   @RequestParam("matricule") String matricules){

        return assuranceServices.ajouterAssurance(a, cinbf,matricules);


    }
    @GetMapping("/oldestContrat/{{idBf}}")
    public Contrat getOldestContractForBeneficiary(@PathVariable("idBf") int idBf) {
        return assuranceServices.getContratBf(idBf);
    }

    @GetMapping("/beneficiairesByType/{typeContrat}")
    public Set<Beneficiare> getBeneficiairesByType(@PathVariable("typeContrat") TypeContrat typeContrat) {
        return assuranceServices.getBeneficiairesByType(typeContrat);
    }

    @GetMapping("/beneficiare/Montant/{idBf}")
    public float getMontantTotal (@PathVariable ("idBf") int idBf){
        return assuranceServices.getMontantBf(idBf);
    }

}

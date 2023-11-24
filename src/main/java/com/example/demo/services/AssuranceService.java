package com.example.demo.services;

import ch.qos.logback.core.net.server.Client;
import com.example.demo.entities.Assurance;
import com.example.demo.entities.Beneficiare;
import com.example.demo.entities.Contrat;
import com.example.demo.entities.TypeContrat;
import com.example.demo.repositories.iAssuranceRepository;
import com.example.demo.repositories.iBeneficiaireRepository;
import com.example.demo.repositories.iContratRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


@Service
@RequiredArgsConstructor
public class AssuranceService implements iAssuranceService {
    private final iBeneficiaireRepository beneficiaireRepository;
    private final iAssuranceRepository assuranceRepository;
    private final iContratRepository  clientRepository ;

    @Transactional
    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
        Contrat c = clientRepository.findContratByMatricule(matricule);
        Beneficiare b= beneficiaireRepository.findBeneficiareByCin(cinBf);
        a.setBeneficiare(b);
        a.setContrats(c);
        return assuranceRepository.save(a);
    }

    @Override
    public Contrat getContratBf(int idBf) {
       return clientRepository.findOldestContractByBeneficiaryId(idBf);
    }

    @Override
    public Set<Beneficiare> getBeneficiairesByType(TypeContrat typeContrat) {
        return clientRepository.findBeneficiairesByTypeContrat(typeContrat);
    }

    @Override
    public float getMontantBf(int cinBf) {
        Beneficiare beneficiare = beneficiaireRepository.findBeneficiareByCin(cinBf);
        float montantTotal = 0.0f;

        for (Assurance assurance : beneficiare.getAssurances()) {
            float montantAssurance = assurance.getMontant();

            if (assurance.getContrats().getTypeC().equals("Semestriel")) {
                montantAssurance *= 2;
            } else if (assurance.getContrats().getTypeC().equals("Mensuel")) {
                montantAssurance *= 12;
            } else if (assurance.getContrats().getTypeC().equals("Annuel")) {
                montantAssurance = assurance.getMontant();
            }

            montantTotal += montantAssurance;
        }

        return montantTotal;
    }
    @Override
    @Scheduled(fixedRate = 60000) // Déclenchement toutes les 60 secondes
    public void statistiques() {
        Map<Integer, Integer> statistiques = new TreeMap<>(Collections.reverseOrder());


        for (Beneficiare beneficiare : beneficiaireRepository.findAll()) {
            int nombreAssurances = beneficiare.getAssurances().size();
            statistiques.put(nombreAssurances, beneficiare.getCin());
        }


        for (Map.Entry<Integer, Integer> entry : statistiques.entrySet()) {
            System.out.println("CIN: " + entry.getValue() + ", Nombre d'assurances: " + entry.getKey());
        }
    }

}

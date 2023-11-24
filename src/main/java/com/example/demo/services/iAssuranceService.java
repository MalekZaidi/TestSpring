package com.example.demo.services;

import com.example.demo.entities.Assurance;
import com.example.demo.entities.Beneficiare;
import com.example.demo.entities.Contrat;
import com.example.demo.entities.TypeContrat;

import java.util.Set;

public interface iAssuranceService {
  Assurance ajouterAssurance (Assurance a, int cinBf, String matricule);

  Contrat getContratBf (int idBf);
  Set<Beneficiare> getBeneficiairesByType(TypeContrat typeContrat);
  float getMontantBf(int cinBf);
  void statistiques();
}

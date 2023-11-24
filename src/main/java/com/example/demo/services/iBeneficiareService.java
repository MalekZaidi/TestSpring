package com.example.demo.services;

import com.example.demo.entities.Beneficiare;
import com.example.demo.entities.Contrat;

import java.util.List;

public interface iBeneficiareService {
     Beneficiare  ajouterBeneficiaire (Beneficiare bf);
    Beneficiare modifierBeneficiare(Beneficiare centre);
    Beneficiare getBeneficiare(Long idBeneficiare);
    void supprimerBeneficiare (Long idBeneficiare);

    List<Beneficiare> getAllBeneficiare();



}

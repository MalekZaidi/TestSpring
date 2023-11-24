package com.example.demo.services;

import com.example.demo.entities.Assurance;
import com.example.demo.entities.Beneficiare;

import java.util.List;

import com.example.demo.repositories.iAssuranceRepository;
import com.example.demo.repositories.iBeneficiaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class BeneficiareService implements iBeneficiareService {
    private final iBeneficiaireRepository centreCommercial;
    private final iAssuranceRepository boutiques;

    @Override
    @Transactional
    public Beneficiare ajouterBeneficiaire(Beneficiare bf) {
        for (Assurance assurance : bf.getAssurances()) {
            assurance.setBeneficiare(bf);
        }


        centreCommercial.save(bf);


        for (Assurance assurance : bf.getAssurances()) {

            assurance.setBeneficiare(bf);
            boutiques.save(assurance);
        }
        return bf;
    }



    @Override
    public Beneficiare modifierBeneficiare(Beneficiare centre) {
       return centreCommercial.save(centre);
    }

    @Override
    public Beneficiare getBeneficiare(Long idBeneficiare) {
        return  centreCommercial.findById(idBeneficiare).orElse(null);
    }

    @Override
    public void supprimerBeneficiare(Long idBeneficiare) {
        centreCommercial.deleteById(idBeneficiare);

    }

    @Override
    public List<Beneficiare> getAllBeneficiare() {
        return (List<Beneficiare>)  centreCommercial.findAll();
    }
}

package com.example.demo.services;

import com.example.demo.entities.Contrat;
import com.example.demo.repositories.iAssuranceRepository;
import com.example.demo.repositories.iContratRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ContratService implements iContratService {
    private final iContratRepository contratRepository;
    private final iAssuranceRepository iboutique;

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return  contratRepository.save(c);
    }
}

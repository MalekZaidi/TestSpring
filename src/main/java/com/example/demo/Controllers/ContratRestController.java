package com.example.demo.Controllers;
import com.example.demo.entities.Beneficiare;
import com.example.demo.entities.Contrat;
import com.example.demo.services.iBeneficiareService;
import com.example.demo.services.iContratService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contrat")
@RequiredArgsConstructor
public class ContratRestController {

    private final iContratService contratService;

    @PostMapping("/add")
    public Contrat addContrat (@RequestBody Contrat c){
      return  contratService.ajouterContrat(c);


    }



}

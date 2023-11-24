package com.example.demo.Controllers;
import com.example.demo.entities.Beneficiare;
import com.example.demo.services.iBeneficiareService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beneficiare")
@RequiredArgsConstructor
public class BeneficiareRestController {

    private final iBeneficiareService b;
    @PostMapping("/add")
    public Beneficiare addBeneficiaire (@RequestBody Beneficiare bf){
       return b.ajouterBeneficiaire(bf);


    }

}

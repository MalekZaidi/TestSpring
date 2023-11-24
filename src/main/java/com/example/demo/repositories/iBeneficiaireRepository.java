package com.example.demo.repositories;

import com.example.demo.entities.Beneficiare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iBeneficiaireRepository extends JpaRepository <Beneficiare, Long> {

Beneficiare findBeneficiareByCin(int cinB);
}

package com.example.demo.repositories;

import com.example.demo.entities.Assurance;
import com.example.demo.entities.Beneficiare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface iAssuranceRepository extends JpaRepository<Assurance,Long> {



}

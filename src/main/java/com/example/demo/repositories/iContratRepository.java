package com.example.demo.repositories;

import com.example.demo.entities.Beneficiare;
import com.example.demo.entities.Contrat;
import com.example.demo.entities.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface iContratRepository extends JpaRepository<Contrat,Long> {

    Contrat findContratByMatricule(String mat);
   // Contrat findContratByDebutEffetOrderByDebutEffetDebutEffetAsc (Contrat contrat);
  //  Contrat findContratBy
   @Query("SELECT c FROM Contrat c JOIN c.assurances a WHERE a.beneficiare.idBenef = :idBf ORDER BY c.debutEffet ASC")
   Contrat findOldestContractByBeneficiaryId(@Param("idBf") int idBf);


    //methdode 1
    @Query("SELECT DISTINCT a.beneficiare FROM Contrat c JOIN c.assurances a WHERE c.TypeC = :typeContrat")
    Set<Beneficiare> findBeneficiairesByTypeContrat(@Param("typeContrat") TypeContrat typeContrat);
    //methode 2
    Contrat findContratByTypeC(TypeContrat typec);
}






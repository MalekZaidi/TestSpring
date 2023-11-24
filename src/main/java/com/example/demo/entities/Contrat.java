package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    private String matricule;
    @Enumerated(EnumType.STRING)
    private TypeContrat TypeC;
    @Temporal(TemporalType.DATE)
    LocalDate debutEffet;

    @OneToMany(mappedBy="contrat")
    private Set<Assurance> assurances;

}

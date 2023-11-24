package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Beneficiare implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idBenef;
    private int cin;
    private String nom;
    private String prenom;
    private String profession;
    private float salaire;
// cascade ={CascadeType.PERSIST,CascadeType.REMOVE} fetch = FetchType.EAGER)
    @OneToMany(mappedBy="beneficiare")
    private Set<Assurance> assurances;


}

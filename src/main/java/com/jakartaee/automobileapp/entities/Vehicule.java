package com.jakartaee.automobileapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jakartaee.automobileapp.enums.CategorieVehicule;
import com.jakartaee.automobileapp.enums.StatusVehicule;
import com.jakartaee.automobileapp.enums.TypeTransmission;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="vehicules")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @PastOrPresent(message = "La date d'entrée doit être dans le passé ou le présent")
    @NotNull(message = "La date d'entrée est obligatoire")
    @Column(nullable = false)
    private LocalDate dateEntree;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVehicule statusVehicule;

    @NotNull(message = "Categorie est requis.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategorieVehicule categorieVehicule;


    @NotNull(message = "Type de Transmission est requis.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeTransmission typeTransmission;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicule_specif_id")
    private VehiculeSpecif vehiculeSpecif;

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Operation> operations;

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Affectation> affectations;


    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Alerte> alertes;
}

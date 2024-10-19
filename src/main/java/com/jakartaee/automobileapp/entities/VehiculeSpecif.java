package com.jakartaee.automobileapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jakartaee.automobileapp.enums.TypeCarburant;
import com.jakartaee.automobileapp.enums.TypeImmatriculation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="vehicules_specifications")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VehiculeSpecif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @NotBlank(message = "Le numéro de chassis est requis.")
    @Column(nullable = false, unique = true)
    private String numeroChassis;

    @NotNull(message = "Le type d'immatriculation est requis.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeImmatriculation typeImmatriculation;

    @NotBlank(message = "L'immatriculation est requise.")
    @Column(nullable = false, unique = true)
    private String immatriculation;

    @NotNull(message = "La puissance est requise.")
    @Positive(message = "La puissance doit être positive.")
    @Column(nullable = false)
    private int puissance;

    @NotNull(message = "Le poids est requis.")
    @Positive(message = "Le poids doit être positif.")
    @Column(nullable = false)
    private int poids;

    @NotNull(message = "Le nombre de places est requis.")
    @Positive(message = "Le nombre de places doit être positif.")
    @Column(nullable = false)
    private int nombreDePlaces;

    @NotNull(message = "Le kilométrage est requis.")
    @Positive(message = "Le kilométrage doit être positif.")
    @Column(nullable = false)
    private Long kilometrage;

    @NotNull(message = "Le modèle est requis.")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modele_id")
    private Modele modele;

    @NotNull(message = "Le type de carburant est requis.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeCarburant typeCarburant;

    @OneToOne(mappedBy = "vehiculeSpecif", fetch = FetchType.LAZY)
    @JsonIgnore
    private Vehicule vehicule;

}

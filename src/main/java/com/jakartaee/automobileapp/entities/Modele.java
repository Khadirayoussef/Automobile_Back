package com.jakartaee.automobileapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "modeles")
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @NotBlank(message = "Le nom du modèle est requis.")
    @Column(nullable = false)
    private String nomModele;

    @NotNull(message = "La marque est requise.")
    @ManyToOne
    @JoinColumn(name = "marque_id")
    private Marque marque;

    @OneToMany(mappedBy = "modele", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<VehiculeSpecif> vehiculesSpecifications;

}

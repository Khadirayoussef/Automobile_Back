package com.jakartaee.automobileapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jakartaee.automobileapp.enums.CategorieMaintenance;
import com.jakartaee.automobileapp.enums.TypeOperation;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="operations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @PastOrPresent(message = "Date operation must be in the past or present")
    @Column(nullable = false)
    private LocalDate dateOperation;

    @Future(message = "La date de fin validite doit être dans le futur.")
    private LocalDate dateFinValidite;

    @NotBlank(message = "Nom de centre is required")
    @Column(nullable = false)
    private String nomCentre;

    @NotBlank(message = "Détails are required")
    @Column(nullable = false)
    private String details;

    @Positive(message = "Cout must be positive")
    @NotNull(message = "Cout is required")
    @Column(nullable = false)
    private double cout;

    @NotNull(message = "Vehicule is required.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @NotNull(message = "Données fichier are required")
    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB")
    private byte[] file;

    @NotBlank(message = "Nom fichier is required")
    @Column(nullable = false)
    private String fileName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private TypeOperation typeOperation;

    @Enumerated(EnumType.STRING)
    private CategorieMaintenance categorieMaintenance; // this one just if typeOperation=Maintenance
}

package com.jakartaee.automobileapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jakartaee.automobileapp.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor @Builder

@Entity
@Table(name = "affectations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "mission_id")
    @JsonIgnore
    private Mission mission;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private LocalDate dateReaction;


    @Positive(message = "Le kilométrage doit être positif.")
    private Long kilometrageInitial;


    @Positive(message = "Le kilométrage doit être positif.")
    private Long kilometrageRetour;

    private String motif;

}

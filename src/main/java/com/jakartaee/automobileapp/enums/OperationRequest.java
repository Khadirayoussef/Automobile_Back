package com.jakartaee.automobileapp.enums;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


public record OperationRequest(
        @PastOrPresent(message = "Date operation must be in the past or present")
        LocalDate dateOperation,

        LocalDate dateFinValidite,

        @NotBlank(message = "Nom de centre is required")
        String nomCentre,

        @NotBlank(message = "Détails are required")
        String details,

        @Positive(message = "Cout must be positive")
        @NotNull(message = "Cout is required")
        double cout,

        @NotNull(message = "Vehicule is required.")
        String immatriculation,

        @NotNull(message = "File is required")
        MultipartFile file,

        @NotBlank(message = "Nom fichier is required")
        String fileName,

        @NotBlank(message = "TypeOperation is required")
        String typeOperation,

        String categorieMaintenance
) {}
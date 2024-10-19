package com.jakartaee.automobileapp.records;


import com.jakartaee.automobileapp.enums.Grade;
import com.jakartaee.automobileapp.enums.RoleUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeRequest(

        @NotBlank(message = "Le nom de l'employé est requis.")
        String nom,

        @NotBlank(message = "Le prénom de l'employé est requis.")
        String prenom,

        @Email(message = "L'adresse email doit être valide.")
        @NotBlank(message = "L'email de l'employé est requis.")
        String email,

        @NotBlank(message = "Cin de user est requis.")
        String cin,

        @NotBlank(message = "Le mot de passe est requis.")
        String password,

        @NotNull(message = "Le rôle de l'employé est requis.")
        RoleUser role,

        @NotNull(message = "Le grade de l'employé est requis.")
        Grade grade,

        Long departementId

) {
}

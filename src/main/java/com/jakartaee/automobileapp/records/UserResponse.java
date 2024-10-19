package com.jakartaee.automobileapp.records;


import com.jakartaee.automobileapp.entities.Departement;
import com.jakartaee.automobileapp.enums.Grade;
import com.jakartaee.automobileapp.enums.RoleUser;
import lombok.Data;


@Data
public class UserResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String cin;
    private RoleUser role;
    private Grade grade;
    private Departement departement;

    public UserResponse(Long id, String nom, String prenom, String email, String cin, RoleUser role, Grade grade) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.role = role;
        this.grade = grade;
    }


}
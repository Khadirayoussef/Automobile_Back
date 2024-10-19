package com.jakartaee.automobileapp.records;


import com.jakartaee.automobileapp.entities.Chef;

public record DepartementResponse(
        Long id,
        String libelle,
        String description,
        Chef chef
) {
}

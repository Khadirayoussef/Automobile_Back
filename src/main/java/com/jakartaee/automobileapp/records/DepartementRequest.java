package com.jakartaee.automobileapp.records;


import com.jakartaee.automobileapp.entities.Chef;
import com.jakartaee.automobileapp.entities.Departement;

public record DepartementRequest(
        Departement departement,
        Chef chef
) {
}

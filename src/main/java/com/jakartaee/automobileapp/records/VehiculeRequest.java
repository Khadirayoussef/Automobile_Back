package com.jakartaee.automobileapp.records;


import com.jakartaee.automobileapp.entities.Vehicule;
import com.jakartaee.automobileapp.entities.VehiculeSpecif;

public record VehiculeRequest(
        Vehicule vehicule,
        VehiculeSpecif vehiculeSpecif
) {
}

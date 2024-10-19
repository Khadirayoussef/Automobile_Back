package com.jakartaee.automobileapp.records;

public record VehiculeFilter(

        String immatriculation,
        String typeImmatriculation,
        String marque,
        String modele,
        String typeCarburant,
        String statusVehicule,
        String categorieVehicule,
        String typeTransmission

) {
}

package com.jakartaee.automobileapp.records;

public record MaintenanceFilter(

        String immatriculation,
        String typeImmatriculation,
        String marque,
        String modele,
        String typeCarburant,
        String centre,
        String categorieMaintenance

) {
}

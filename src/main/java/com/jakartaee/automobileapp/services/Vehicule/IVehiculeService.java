    package com.jakartaee.automobileapp.services.Vehicule;



    import com.jakartaee.automobileapp.entities.Vehicule;
    import com.jakartaee.automobileapp.records.VehiculeFilter;
    import com.jakartaee.automobileapp.records.VehiculeRequest;

    import java.time.LocalDate;
    import java.util.List;

    public interface IVehiculeService {

        Vehicule createVehicule(VehiculeRequest vehiculeRequest);
        Vehicule getVehiculeById(Long id);
        Vehicule updateVehicule(Long id, VehiculeRequest vehiculeRequest);
        void deleteVehicule(Long id);

        List<Vehicule> getAllVehicules();

        List<Vehicule> filterVehicules(VehiculeFilter filter);

        List<Vehicule> findAvailableVehicles(LocalDate startDate, LocalDate endDate);

        long countVehicules();
    }

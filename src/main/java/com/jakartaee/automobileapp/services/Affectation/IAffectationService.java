package com.jakartaee.automobileapp.services.Affectation;


import com.jakartaee.automobileapp.entities.Affectation;

public interface IAffectationService {


    Affectation rejectAffectation(Long affectationId, String motif);
    public Affectation assignVehicleToAffectation(Long affectationId, String motif, Long vehiculeId);

    Affectation updateKilometrage(Long id,Long kilometrageInitial,Long kilometrageRetour);

}

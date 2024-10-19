package com.jakartaee.automobileapp.services.Departement;


import com.jakartaee.automobileapp.entities.Departement;
import com.jakartaee.automobileapp.records.DepartementRequest;

import java.util.List;

public interface IDepartementService {

    Departement createDepartement(DepartementRequest departementRequest);
    Departement updateDepartement(Long id,DepartementRequest departementRequest);
    Departement getDepartement(Long id);
    List<Departement> getAllDepartement();
    void deleteDepartement(Long id);


    long countDepartements();
}

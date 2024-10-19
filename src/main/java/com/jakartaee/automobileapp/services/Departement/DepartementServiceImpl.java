package com.jakartaee.automobileapp.services.Departement;


import com.jakartaee.automobileapp.entities.Chef;
import com.jakartaee.automobileapp.entities.Departement;
import com.jakartaee.automobileapp.records.DepartementRequest;
import com.jakartaee.automobileapp.repositories.DepartementRepository;
import com.jakartaee.automobileapp.services.User.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartementServiceImpl implements IDepartementService{

    private final DepartementRepository departementRepository;
    private final IUserService iUserService;

    @Override
    public Departement createDepartement(DepartementRequest departementRequest) {

        Chef chef = departementRequest.chef();

        Departement departement = departementRequest.departement();

        departement.setChef(chef);

        return departementRepository.save(departement);

    }

    @Override
    public Departement updateDepartement(Long id,DepartementRequest departementRequest) {

        Departement existingDepartement = departementRepository.findById(id).orElseThrow(() -> new RuntimeException("departement not found with id " + id));
        Chef chef = iUserService.updateChef(existingDepartement.getChef().getId(),departementRequest.chef());
        existingDepartement.setLibelle(departementRequest.departement().getLibelle());
        existingDepartement.setDescription(departementRequest.departement().getDescription());
        existingDepartement.setChef(chef);

        Departement updatedDepartement = departementRepository.save(existingDepartement);

        return updatedDepartement;
    }

    @Override
    public Departement getDepartement(Long id) {
        Departement departement = departementRepository.findById(id).orElseThrow(() -> new RuntimeException("departement not found with id " + id));
        return departement;
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }


    @Override
    public void deleteDepartement(Long id){
        departementRepository.deleteById(id);
    }

    @Override
    public long countDepartements() {
        return departementRepository.count();
    }
}

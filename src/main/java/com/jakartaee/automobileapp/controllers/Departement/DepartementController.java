package com.jakartaee.automobileapp.controllers.Departement;

import com.jakartaee.automobileapp.entities.Departement;
import com.jakartaee.automobileapp.records.DepartementRequest;
import com.jakartaee.automobileapp.services.Departement.IDepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("departements")
public class DepartementController {

    private final IDepartementService iDepartementService;


    @PostMapping
    public ResponseEntity<Departement> createDepartement(@RequestBody DepartementRequest departementRequest) {
        Departement departement = iDepartementService.createDepartement(departementRequest);
        return ResponseEntity.ok(departement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) {
        iDepartementService.deleteDepartement(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id , @RequestBody DepartementRequest departementRequest) {
        Departement departement = iDepartementService.updateDepartement(id,departementRequest);
        return ResponseEntity.ok(departement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartement(@PathVariable Long id) {
        Departement departement = iDepartementService.getDepartement(id);
        return ResponseEntity.ok(departement);
    }

    @GetMapping
    public ResponseEntity<List<Departement>> getDepartements() {
        List<Departement> departements = iDepartementService.getAllDepartement();
        return ResponseEntity.ok(departements);
    }




}

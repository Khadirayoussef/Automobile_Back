package com.jakartaee.automobileapp.repositories;


import com.jakartaee.automobileapp.entities.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation,Long> {


    @Query("SELECT a.vehicule.vehiculeSpecif.immatriculation FROM Affectation a")
    List<String> findAllMatricules();


}

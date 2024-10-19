package com.jakartaee.automobileapp.repositories;


import com.jakartaee.automobileapp.entities.VehiculeSpecif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculeSpecifRepository extends JpaRepository<VehiculeSpecif, Long> {

    long countByModeleId(Long modeleId);

    @Query("SELECT v.immatriculation FROM VehiculeSpecif v")
    List<String> findAllImmatriculations();

    List<VehiculeSpecif> findByModeleId(Long modeleId);


    @Query("SELECT vs FROM VehiculeSpecif vs " +
            "JOIN FETCH vs.modele m " +
            "JOIN FETCH m.marque")
    List<VehiculeSpecif> findAllWithEagerLoading();

    @Query("SELECT vs FROM VehiculeSpecif vs " +
            "JOIN FETCH vs.modele m " +
            "JOIN FETCH m.marque " +
            "WHERE vs.id = :id")
    Optional<VehiculeSpecif> findByIdWithEagerLoading(@Param("id") Long id);

    @Query("SELECT COUNT(v) <= 1 FROM VehiculeSpecif v WHERE v.modele.id = :modeleId")
    boolean existsByModeleId(@Param("modeleId") Long modeleId);


}

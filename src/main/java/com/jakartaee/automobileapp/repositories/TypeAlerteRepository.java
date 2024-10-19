package com.jakartaee.automobileapp.repositories;


import com.jakartaee.automobileapp.entities.TypeAlerte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeAlerteRepository extends JpaRepository<TypeAlerte, Long> {

    Optional<TypeAlerte> findByName(String name);



}

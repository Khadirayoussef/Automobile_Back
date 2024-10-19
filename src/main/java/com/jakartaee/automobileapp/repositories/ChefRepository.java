package com.jakartaee.automobileapp.repositories;


import com.jakartaee.automobileapp.entities.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {
}

package com.jakartaee.automobileapp.repositories;


import com.jakartaee.automobileapp.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {

    List<Employe> findAllByDepartementId(Long departementId);


}

package com.jakartaee.automobileapp.services.User;


import com.jakartaee.automobileapp.entities.Chef;
import com.jakartaee.automobileapp.entities.Employe;
import com.jakartaee.automobileapp.entities.User;
import com.jakartaee.automobileapp.records.EmployeFilter;
import com.jakartaee.automobileapp.records.EmployeRequest;

import java.util.List;

public interface IUserService {

    //user

    //chef
    Chef updateChef(Long id, Chef chef);

    //chef
    Employe createEmploye(EmployeRequest employeRequest);
    void deleteEmploye(Long id);
    Employe updateEmploye(Long id,EmployeRequest employeRequest);
    Employe getEmployeById(Long id);

    List<Employe> getAllEmployes();
    List<Employe> getAllEmployesByDepartement(Long id);

    User authenticateUser(String email, String password);

    List<Employe> filterEmployes(Long id, EmployeFilter filter);

    long countEmployes();

}

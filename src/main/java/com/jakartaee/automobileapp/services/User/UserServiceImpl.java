package com.jakartaee.automobileapp.services.User;


import com.jakartaee.automobileapp.entities.Chef;
import com.jakartaee.automobileapp.entities.Employe;
import com.jakartaee.automobileapp.entities.User;
import com.jakartaee.automobileapp.enums.RoleUser;
import com.jakartaee.automobileapp.exceptions.NoVehiculesFoundException;
import com.jakartaee.automobileapp.records.EmployeFilter;
import com.jakartaee.automobileapp.records.EmployeRequest;
import com.jakartaee.automobileapp.repositories.ChefRepository;
import com.jakartaee.automobileapp.repositories.DepartementRepository;
import com.jakartaee.automobileapp.repositories.EmployeRepository;
import com.jakartaee.automobileapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final ChefRepository chefRepository;
    private final EmployeRepository employeRepository;
    private final DepartementRepository departementRepository;
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Chef updateChef(Long id, Chef chef) {
        Chef existingChef = chefRepository.findById(id).orElseThrow(() -> new RuntimeException("chef not found with id " + id));
        String encodedPassword = passwordEncoder.encode(chef.getPassword());
        existingChef.setNom(chef.getNom());
        existingChef.setPrenom(chef.getPrenom());
        existingChef.setEmail(chef.getEmail());
        existingChef.setCin(chef.getCin());
        existingChef.setPassword(encodedPassword);
        existingChef.setRole(chef.getRole());
        existingChef.setGrade(chef.getGrade());

        Chef updatedChef = chefRepository.save(existingChef);

        return updatedChef;
    }

    public Employe createEmploye(EmployeRequest employeRequest) {
        // Encode the password
        String encodedPassword = passwordEncoder.encode(employeRequest.password());

        Employe employe = Employe.builder()
                .nom(employeRequest.nom())
                .prenom(employeRequest.prenom())
                .email(employeRequest.email())
                .cin(employeRequest.cin())
                .password(encodedPassword)  // Use the encoded password
                .role(employeRequest.role())
                .grade(employeRequest.grade())
                .departement(departementRepository.findById(employeRequest.departementId())
                        .orElseThrow(() -> new RuntimeException("Department not found with id " + employeRequest.departementId())))
                .build();

        return employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe updateEmploye(Long id, EmployeRequest employeRequest) {
        Employe existingEmploye = getEmployeById(id);

        existingEmploye.setNom(employeRequest.nom());
        existingEmploye.setPrenom(employeRequest.prenom());
        existingEmploye.setEmail(employeRequest.email());
        existingEmploye.setCin(employeRequest.cin());
        existingEmploye.setPassword(employeRequest.password());
        existingEmploye.setRole(employeRequest.role());
        existingEmploye.setGrade(employeRequest.grade());

        return employeRepository.save(existingEmploye);
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee not found with id " + id));
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public List<Employe> getAllEmployesByDepartement(Long id) {
        return employeRepository.findAllByDepartementId(id);
    }

    @Override
    @Transactional
    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            if (user.getRole() == RoleUser.CHEF_DEPARTMENT) {
                return chefRepository.findById(user.getId()).orElse(null);
            } else if (user.getRole() == RoleUser.EMPLOYE) {
                return employeRepository.findById(user.getId()).orElse(null);
            }
        }
        return user;
    }






    @Override
    public List<Employe> filterEmployes(Long id, EmployeFilter filter) {
        List<Employe> employes = employeRepository.findAllByDepartementId(id);

        List<Employe> filteredEmployes = employes.stream().filter(employe -> {
            boolean matches = true;

            if (filter.cin() != null && !filter.cin().isEmpty()) {
                matches = matches && filter.cin().equalsIgnoreCase(employe.getCin());
            }

            if (filter.nom() != null && !filter.nom().isEmpty()) {
                matches = matches && filter.nom().equalsIgnoreCase(employe.getNom());
            }

            if (filter.prenom() != null && !filter.prenom().isEmpty()) {
                matches = matches && filter.prenom().equalsIgnoreCase(employe.getPrenom());
            }

            if (filter.grade() != null && !filter.grade().isEmpty()) {
                matches = matches && filter.grade().equalsIgnoreCase(String.valueOf(employe.getGrade()));
            }

            return matches;
        }).collect(Collectors.toList());

        // Reverse the list
        Collections.reverse(filteredEmployes);

        if (filteredEmployes.isEmpty()) {
            throw new NoVehiculesFoundException("Aucun Employe was found with this filtering.");
        }

        return filteredEmployes;
    }


    @Override
    public long countEmployes() {
        return userRepository.count();
    }






}

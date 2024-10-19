package com.jakartaee.automobileapp.controllers.User;


import com.jakartaee.automobileapp.entities.Employe;
import com.jakartaee.automobileapp.exceptions.NoVehiculesFoundException;
import com.jakartaee.automobileapp.jwt.AuthenticationService;
import com.jakartaee.automobileapp.jwt.JwtResponse;
import com.jakartaee.automobileapp.records.EmployeFilter;
import com.jakartaee.automobileapp.records.EmployeRequest;
import com.jakartaee.automobileapp.records.LoginRequest;
import com.jakartaee.automobileapp.services.User.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final IUserService iUserService;
    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;


    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody EmployeRequest EmployeRequest) {
        Employe employe = iUserService.createEmploye(EmployeRequest);
        return ResponseEntity.ok(employe);
    }

    @GetMapping("/employes/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        Employe employe = iUserService.getEmployeById(id);
        return ResponseEntity.ok(employe);
    }

    @PutMapping("/employes/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody EmployeRequest employeRequest) {
        Employe updatedEmploye = iUserService.updateEmploye(id, employeRequest);
        return ResponseEntity.ok(updatedEmploye);
    }

    @DeleteMapping("/employes/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        iUserService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/employes")
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe> employes = iUserService.getAllEmployes();
        return ResponseEntity.ok(employes);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("hey");
        try {
            JwtResponse jwtResponse = authenticationService.login(loginRequest.email(), loginRequest.password(), authenticationManager);
            return ResponseEntity.ok(jwtResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }



    @GetMapping("/employes/departement/{id}")
    public ResponseEntity<List<Employe>> getAllEmployesByDepartement(@PathVariable Long id) {
        List<Employe> employes = iUserService.getAllEmployesByDepartement(id);
        return ResponseEntity.ok(employes);
    }

    @PostMapping("/employes/filter/{id}")
    public ResponseEntity<?> filterEmployes(@PathVariable Long id,@RequestBody EmployeFilter filter) {
        try {
            List<Employe> employes = iUserService.filterEmployes(id,filter);
            return new ResponseEntity<>(employes, HttpStatus.OK);
        } catch (NoVehiculesFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}

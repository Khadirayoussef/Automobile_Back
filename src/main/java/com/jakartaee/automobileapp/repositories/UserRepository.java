package com.jakartaee.automobileapp.repositories;


import com.jakartaee.automobileapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}

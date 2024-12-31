package com.example.Genesis.Project.repository;

import com.example.Genesis.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean findByPersonID(String personID);
    boolean existsByPersonID(String personID);
}




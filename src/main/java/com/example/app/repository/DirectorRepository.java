package com.example.app.repository;

import com.example.app.model.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    long count();
}

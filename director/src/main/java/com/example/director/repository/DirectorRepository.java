package com.example.director.repository;

import com.example.director.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository <Director, Long>{
    
}

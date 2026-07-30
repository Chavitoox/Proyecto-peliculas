package com.example.recomendacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recomendacion.model.Recomendacion;

public interface  RecomendacionRepository extends JpaRepository<Recomendacion, Long> {
    
}

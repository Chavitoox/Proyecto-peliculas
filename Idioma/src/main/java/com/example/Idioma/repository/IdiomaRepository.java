package com.example.Idioma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Idioma.model.Idioma;



public interface IdiomaRepository extends JpaRepository <Idioma ,Long>{
      boolean existsByLenguajeAndVersion(String lenguaje, String version);
}


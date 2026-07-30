package com.example.pelicula.repository;

import com.example.pelicula.model.PeliculaIdioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaIdiomaRepository extends JpaRepository<PeliculaIdioma, Long> {
}

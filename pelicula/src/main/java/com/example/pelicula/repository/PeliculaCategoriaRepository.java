package com.example.pelicula.repository;

import com.example.pelicula.model.PeliculaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaCategoriaRepository extends JpaRepository<PeliculaCategoria, Long> {
}

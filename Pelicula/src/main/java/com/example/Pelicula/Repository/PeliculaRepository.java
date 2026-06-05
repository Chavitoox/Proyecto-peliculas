package com.example.pelicula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pelicula.model.Pelicula;
import java.util.List;
public interface PeliculaRepository extends JpaRepository <Pelicula ,Long>{
    List<Pelicula> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}


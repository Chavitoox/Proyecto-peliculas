package com.example.Pelicula.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Pelicula.Model.Pelicula;

import java.util.List;
public interface PeliculaRepository extends JpaRepository <Pelicula ,Long>{
    List<Pelicula> findByNombre(String nombre);
}
 
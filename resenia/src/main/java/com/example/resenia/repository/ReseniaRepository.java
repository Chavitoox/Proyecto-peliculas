package com.example.resenia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.resenia.model.Resenia;
import java.util.List;

@Repository
public interface ReseniaRepository extends JpaRepository<Resenia, Long> {
    List<Resenia> findByIdPelicula(Long idPelicula);
}
package com.example.Categoria.repository;
import com.example.Categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria ,Long>{
    Categoria findByNombreCategoria(String nombreCategoria);
    boolean existsByNombreCategoria(String nombreCategoria);

}

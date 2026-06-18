package com.example.categoria.repository;
import com.example.categoria.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CategoriaRepository extends MongoRepository<Categoria, String>{
    Categoria findByNombreCategoria(String nombreCategoria);
    boolean existsByNombreCategoria(String nombreCategoria);

}

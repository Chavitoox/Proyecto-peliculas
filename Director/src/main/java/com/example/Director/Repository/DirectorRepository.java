package com.example.Director.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Director.Model.Director;

public interface  DirectorRepository extends MongoRepository<Director, String> {
    
    Boolean existByNombre(String nombre);

    List<Director> findByNombre(String nombre);
}

package com.example.director.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.director.model.Director;

public interface  DirectorRepository extends MongoRepository<Director, String> {
    Director findByNombreDirector(String nombre);
}


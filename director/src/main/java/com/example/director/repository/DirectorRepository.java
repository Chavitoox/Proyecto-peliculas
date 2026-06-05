package com.example.director.repository;

import com.example.director.model.Director;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface  DirectorRepository extends MongoRepository<Director, String> {
}

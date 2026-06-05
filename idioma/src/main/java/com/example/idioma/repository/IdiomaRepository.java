package com.example.idioma.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.idioma.model.Idioma;

public interface IdiomaRepository extends MongoRepository <Idioma , String> {
    boolean existsByLenguajeAndVersion(String lenguaje, String version);
}

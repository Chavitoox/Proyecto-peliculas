package com.example.idioma.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.idioma.model.Idioma;
import java.util.List;

public interface IdiomaRepository extends MongoRepository <Idioma , String> {
    List<Idioma> findByVersion (String version);
    List<Idioma> findByLenguaje (String lenguaje);
}

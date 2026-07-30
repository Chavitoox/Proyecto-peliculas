package com.example.Idioma.service;
import com.example.Idioma.model.Idioma;
import com.example.Idioma.exception.RecursoNoEncontradoException;
import com.example.Idioma.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IdiomaService {
    @Autowired
    private IdiomaRepository repo;

    public List<Idioma> listar() {
        return repo.findAll();
    }
        public Idioma buscarPorId( long id){
        return repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Idioma no encontrado"));
    }

        public Idioma crear( Idioma i) {
        if(repo.existsByLenguajeAndVersion(i.getLenguaje(), i.getVersion())){
            throw new RecursoNoEncontradoException("Ya existe un idioma con esta combinación de lenguaje y versión");
        }
        return repo.save(i);
        
    }
        public Idioma actualizar( long id, Idioma i) {
        Idioma existe = repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Idioma no encontrado"));

        if(repo.existsByLenguajeAndVersion(i.getLenguaje(), i.getVersion()) 
        && !(existe.getLenguaje().equals(i.getLenguaje()) && existe.getVersion().equals(i.getVersion()))) {
            throw new RecursoNoEncontradoException("Esta combinación de idioma y versión ya existe");
        }

        existe.setVersion(i.getVersion());
        existe.setLenguaje(i.getLenguaje());
        return repo.save(existe);
    }
        public void eliminar( long id){
        repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Idioma no encontrado"));
        repo.deleteById(id);
    
    }
}

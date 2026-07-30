package com.example.director.service;

import com.example.director.model.Director;
import com.example.director.exception.RecursoNoEncontradoException;
import com.example.director.repository.DirectorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DirectorService {
    @Autowired
    private DirectorRepository repo;

    public List<Director> listar(){
        return repo.findAll();
    }

    public Director buscarPorId(Long id){
        return repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Director no encontrado"));
    }

    public Director crear(Director d){
        return repo.save(d);
    }

    public Director actualizar(Long id, Director d){
        Director existe = repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Director no encontrado"));
        existe.setNombreDirector(d.getNombreDirector());
        existe.setNacionalidad(d.getNacionalidad());
        return repo.save(existe);
    }

    public void eliminar(Long id){
        repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Director no encontrada"));
        repo.deleteById(id);
    }


}

package com.example.Categoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Categoria.model.Categoria;
import com.example.Categoria.repository.CategoriaRepository;
import com.example.Categoria.exception.RecursoNoEncontradoException;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public List<Categoria> listar() {
        return repo.findAll();
    }

    public Categoria buscarPorId(long id) {
        return repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrada"));
    }

    public Categoria crear( Categoria c) {
        if (repo.existsByNombreCategoria(c.getNombreCategoria())) {
            throw new RecursoNoEncontradoException("La categoria ingresada ya existe");
        }
        return repo.save(c);

    }

    public Categoria actualizar( long id, Categoria c) {
        Categoria existe = repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrada"));

        if (repo.existsByNombreCategoria(c.getNombreCategoria())
                && !existe.getNombreCategoria().equals(c.getNombreCategoria())) {
            throw new RecursoNoEncontradoException("Esa categoria ya existe");
        }

        existe.setNombreCategoria(c.getNombreCategoria());

        return repo.save(existe);
    }

    public void eliminar( long id) {
        repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrada"));

        repo.deleteById(id);
    }

}

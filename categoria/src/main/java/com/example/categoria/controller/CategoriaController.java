package com.example.categoria.controller;

import com.example.categoria.model.Categoria;
import com.example.categoria.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    public CategoriaRepository repo;

    @GetMapping
    public List<Categoria> listar(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable String id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria c){
        return repo.save(c);
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable String id, @RequestBody Categoria c){
        Categoria existe = repo.findById(id).orElse(null);

        if(existe == null){
            return null;
        }

        existe.setNombreCategoria(c.getNombreCategoria());
        
        return repo.save(existe);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id){
        Categoria existe = repo.findById(id).orElse(null);

        if(existe == null){
            return "No se encontro el id buscado";
        }
        
        repo.deleteById(id);
        return "Categoria eliminada exitosamente";
    }

}

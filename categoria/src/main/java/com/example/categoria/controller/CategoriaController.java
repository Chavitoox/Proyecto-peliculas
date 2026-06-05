package com.example.categoria.controller;

import com.example.categoria.model.Categoria;
import com.example.categoria.repository.CategoriaRepository;
import com.example.categoria.Exception.RecursoNoEncontradoException;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    public CategoriaRepository repo;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id){
        return ResponseEntity.ok().body(repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Categoria no encontrada")));
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Categoria c){
        if(repo.existsByNombreCategoria(c.getNombreCategoria())){
            return ResponseEntity.badRequest().body("La categoria ingresada ya existe");
        }

        return ResponseEntity.ok().body(repo.save(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable String id, @Valid @RequestBody Categoria c){
        Categoria existe = repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Categoria no encontrada"));

        if (repo.existsByNombreCategoria(c.getNombreCategoria()) && !existe.getNombreCategoria().equals(c.getNombreCategoria())) {
            return ResponseEntity.badRequest().body("La categoria ingresada ya existe");
        }

        existe.setNombreCategoria(c.getNombreCategoria());
        
        return ResponseEntity.ok().body(repo.save(existe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id){
        repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Categoria no encontrada"));

        repo.deleteById(id);
        return ResponseEntity.ok().body("Categoria eliminada exitosamente");
    }
    

}

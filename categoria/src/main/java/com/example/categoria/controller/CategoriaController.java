package com.example.categoria.controller;

import com.example.categoria.model.Categoria;
import com.example.categoria.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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
        return ResponseEntity.ok().body(repo.findById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Categoria c){
        if(c.getNombreCategoria() == null || c.getNombreCategoria().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El nombre de la categoria no puede estar vacio");
        }

        if(repo.existsByNombreCategoria(c.getNombreCategoria())){
            return ResponseEntity.badRequest().body("La categoria ingresada ya existe");
        }

        return ResponseEntity.ok().body(repo.save(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable String id, @RequestBody Categoria c){
        Categoria existe = repo.findById(id).orElse(null);

        if(existe == null){
            return ResponseEntity.badRequest().body("Id no encontrado");
        }

        if(c.getNombreCategoria() == null || c.getNombreCategoria().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El nombre de la categoria no puede estar vacio");
        }

        if (repo.existsByNombreCategoria(c.getNombreCategoria()) && !existe.getNombreCategoria().equals(c.getNombreCategoria())) {
            return ResponseEntity.badRequest().body("La categoria ingresada ya existe");
        }

        existe.setNombreCategoria(c.getNombreCategoria());
        
        return ResponseEntity.ok().body(repo.save(existe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id){
        Categoria existe = repo.findById(id).orElse(null);

        if(existe == null){
            return ResponseEntity.badRequest().body("Id no encontrado");
        }

        repo.deleteById(id);
        return ResponseEntity.ok().body("Categoria eliminada exitosamente");
    }

}

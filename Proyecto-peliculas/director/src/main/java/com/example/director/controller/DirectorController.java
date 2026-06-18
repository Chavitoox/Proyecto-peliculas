package com.example.director.controller;

import com.example.director.model.Director;
import com.example.director.repository.DirectorRepository;
import com.example.director.Exception.RecursoNoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/directores")
public class DirectorController {
    
    @Autowired
    private DirectorRepository repo;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id){
        return ResponseEntity.ok().body(repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Director no encontrado")));
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Director d){
        return ResponseEntity.ok().body(repo.save(d));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Director d, @PathVariable  String id ){

        Director existe = repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Director no encontrado"));

        existe.setNombre(d.getNombre());
        existe.setNacionalidad(d.getNacionalidad());

        return ResponseEntity.ok().body(repo.save(existe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable  String id){
        repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Director no encontrado"));

        repo.deleteById(id);
        return ResponseEntity.ok().body("Director eliminado exitosamente");
    }
}

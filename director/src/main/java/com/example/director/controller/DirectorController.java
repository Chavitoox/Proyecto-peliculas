package com.example.director.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.director.model.Director;
import com.example.director.repository.DirectorRepository;

@RestController
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    private DirectorRepository repo;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(repo.findById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Director d) {

        if (d.getNombreDirector() == null || d.getNombreDirector().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo NOMBRE no puede estar vacio");
        }

        if (d.getNacionalidad() == null || d.getNacionalidad().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo NACIONALIDAD no puede estar vacio");
        }

        return ResponseEntity.ok().body(repo.save(d));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Director d, @PathVariable String id) {

        Director existente = repo.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.badRequest().body("Id no encontrado");
        }

        if (d.getNombreDirector() == null || d.getNombreDirector().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre del director no puede estar vacio");
        }

        if (d.getNacionalidad() == null || d.getNacionalidad().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La nacionalidad no puede estar vacia");
        }

        existente.setNombreDirector(d.getNombreDirector());
        existente.setNacionalidad(d.getNacionalidad());

        return ResponseEntity.ok().body(repo.save(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id) {
        Director existe = repo.findById(id).orElse(null);

        if (existe == null) {
            return ResponseEntity.badRequest().body("Id no encontrado");
        }

        repo.deleteById(id);
        return ResponseEntity.ok().body("Director eliminado exitosamente");
    }

}


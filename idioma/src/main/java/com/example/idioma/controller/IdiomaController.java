package com.example.idioma.controller;

import com.example.idioma.Exception.RecursoNoEncontradoException;
import com.example.idioma.model.Idioma;
import com.example.idioma.repository.IdiomaRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/idiomas")
public class IdiomaController {
    @Autowired
    private IdiomaRepository repo;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id){
        return ResponseEntity.ok().body(repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Idioma no encontrado")));
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Idioma i) {
        if(repo.existsByLenguajeAndVersion(i.getLenguaje(), i.getVersion())){
            return ResponseEntity.badRequest().body("Ya existe un idioma con esta combinación de lenguaje y versión");
        }
        return ResponseEntity.ok().body(repo.save(i));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable String id, @Valid @RequestBody Idioma i) {
        Idioma existe = repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Idioma no encontrado"));

        if(repo.existsByLenguajeAndVersion(i.getLenguaje(), i.getVersion()) 
        && !(existe.getLenguaje().equals(i.getLenguaje()) && existe.getVersion().equals(i.getVersion()))) {
            return ResponseEntity.badRequest().body("Esta combinación de idioma y versión ya existe");
        }

        existe.setVersion(i.getVersion());
        existe.setLenguaje(i.getLenguaje());
        return ResponseEntity.ok().body(repo.save(existe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id){
        repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Idioma no encontrado"));

        repo.deleteById(id);
        return ResponseEntity.ok().body("Idioma eliminado exitosamente");
    }
}


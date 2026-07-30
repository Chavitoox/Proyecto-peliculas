package com.example.pelicula.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.pelicula.model.Pelicula;
import com.example.pelicula.dto.PeliculaRequestDTO;
import com.example.pelicula.service.PeliculaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }


    @PostMapping
    public ResponseEntity<?> crear (@Valid @RequestBody PeliculaRequestDTO dto){
        // Le pasamos la "caja" completa al service y respondemos con un 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable Long id, @Valid @RequestBody Pelicula p){
        return ResponseEntity.ok().body(service.actualizar(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Eliminar(@PathVariable long id){
        service.eliminar(id);
        return ResponseEntity.ok().body("Pelicula borrada correctamente");
    }
}
package com.example.pelicula.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.pelicula.model.Pelicula;
import com.example.pelicula.service.PeliculaService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/peliculas")

public class PeliculaController {
    @Autowired
    private PeliculaService service;

    @GetMapping
    public ResponseEntity<?> listar (){
        return service.listar(); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> crear (@Valid @RequestBody Pelicula p){
        return service.crear(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable Long id, @Valid @RequestBody Pelicula p){
        return service.actualizar(id, p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Eliminar(@PathVariable long id){
        return service.Eliminar(id);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> mostrarDetalle(@PathVariable Long id){
        return service.mostrarDetalle(id);
    }
    
}
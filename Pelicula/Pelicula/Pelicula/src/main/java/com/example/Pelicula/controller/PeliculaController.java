package com.example.Pelicula.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.Pelicula.Model.Pelicula;
import com.example.Pelicula.service.PeliculaService;

@RestController
@RequestMapping("/peliculas")

public class PeliculaController {
    @Autowired
    private PeliculaService service;

    @GetMapping
    public ResponseEntity<?> listar (){
        return service.listar(); 
    }
    @PostMapping
    public ResponseEntity<?> crear (@RequestBody Pelicula p){
        return service.crear(p);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable Long id,@RequestBody Pelicula p){
        return service.actualizar(id, p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Eliminar(@PathVariable long id){
        return service.Eliminar(id);
    }
    @PostMapping("/Guardar")
    public ResponseEntity<?> guardarIdioma (@RequestBody Pelicula p){
        return service.guardarIdioma(p);
    }
    @GetMapping("/{id}/detalle")
    public ResponseEntity<?> MostrarIdioma(@PathVariable Long id){
        return service.mostrarDatos(id);
    }
    
}

package com.example.resenia.controller;

import com.example.resenia.model.Resenia;
import com.example.resenia.service.ReseniaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resenias")
public class ReseniaController {

    @Autowired
    private ReseniaService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.listar());
    }

    // Endpoint extra para filtrar las reseñas de una sola película
    @GetMapping("/pelicula/{idPelicula}")
    public ResponseEntity<?> listarPorPelicula(@PathVariable Long idPelicula) {
        return ResponseEntity.ok().body(service.listarPorPelicula(idPelicula));
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Resenia r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok().body("Reseña eliminada correctamente");
    }
}
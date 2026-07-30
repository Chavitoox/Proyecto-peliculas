package com.example.Idioma.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.Idioma.model.Idioma;
import com.example.Idioma.service.IdiomaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/idiomas")
public class IdiomaController {
    @Autowired
    private IdiomaService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Idioma i) {
        return ResponseEntity.ok().body(service.crear(i));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Idioma i) {
        return ResponseEntity.ok().body(service.actualizar(id, i));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok().body("Idioma eliminada Exitosamente");
    }

}

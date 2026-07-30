package com.example.recomendacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recomendacion.model.Recomendacion;
import com.example.recomendacion.service.RecomendacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {
    @Autowired RecomendacionService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Recomendacion r){
        return ResponseEntity.ok().body(service.crear(r));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Recomendacion r){
        return ResponseEntity.ok().body(service.actualizar(id, r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.ok().body("Recomendacion eliminada correctamente");
    }
}
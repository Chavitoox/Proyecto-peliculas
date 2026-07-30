package com.example.notificacion.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notificacion.model.Notificacion;
import com.example.notificacion.service.NotificacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
    @Autowired
    private NotificacionService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarPorId(@Valid @PathVariable Long id){
         return ResponseEntity.ok().body(service.buscarPorId(id));    
    }

     @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Notificacion n) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(n));
    }


        @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok().body("Notificacion eliminada correctamente");
    }
    
}

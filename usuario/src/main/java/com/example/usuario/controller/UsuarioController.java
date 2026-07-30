package com.example.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.usuario.model.Usuario;
import com.example.usuario.service.UsuarioService;

import jakarta.validation.Valid;
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired UsuarioService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario u){
        return ResponseEntity.ok().body(service.crear(u));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Usuario u){
        return ResponseEntity.ok().body(service.actualizar(id, u));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.ok().body("Usuario eliminado correctamente");
    }
}    
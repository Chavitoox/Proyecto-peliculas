package com.example.CarritoCompra.controller;


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

import com.example.CarritoCompra.model.CarritoCompra;
import com.example.CarritoCompra.service.CarritoCompraService;

@RestController
@RequestMapping("/carritoCompra")
public class CarritoCompraController {

    @Autowired
    private CarritoCompraService service;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody CarritoCompra c){
        return service.registrarCompra(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        return service.eliminarCompra(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody CarritoCompra c){
        return  service.actualizarCompra(c, id);
    }

    @GetMapping
    public ResponseEntity<?> listar(){
        return service.listarCompras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCompra(@PathVariable Long id){
        return service.buscarIdCompra(id);
    }


}

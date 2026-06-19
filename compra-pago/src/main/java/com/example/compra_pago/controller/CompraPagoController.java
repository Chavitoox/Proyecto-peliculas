package com.example.compra_pago.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.compra_pago.model.CompraPago;
import com.example.compra_pago.repository.CompraPagoRepository;
import com.example.compra_pago.service.CompraPagoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/pagoCompra")
public class CompraPagoController {
        @Autowired
    private CompraPagoRepository repo;

    @Autowired
    private CompraPagoService service;


    @GetMapping
    public ResponseEntity<?> listar(){
        List<CompraPago> lista = repo.findAll();
        
        if(lista.isEmpty()){
            return ResponseEntity.badRequest().body("pagos de las Compras No encontrados");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody CompraPago p){
        return service.guardar(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id){
        if(!repo.existsById(id)){
            return ResponseEntity.status(404).body("Pago de la compra no Encontrado!");
        }

        repo.deleteById(id);
        return ResponseEntity.ok("Pago Eliminado Correctamente");
    }

    
    


}


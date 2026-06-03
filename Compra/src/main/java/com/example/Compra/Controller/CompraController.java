package com.example.Compra.Controller;

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

import com.example.Compra.Model.Compra;
import com.example.Compra.Service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService service;

    @PostMapping("/compra")
    public ResponseEntity<?> registrar(@RequestBody Compra c){
        return service.registrarCompra(c);
    }

    @DeleteMapping("/compra/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        return service.eliminarCompra(id);
    }

    @PutMapping("/compra/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Compra c){
        return  service.actualizarCompra(c, id);
    }

    @GetMapping("/compra/listar") 
    public ResponseEntity<?> listar(){
        return service.listarCompras();
    }

    @GetMapping("/compra/{id}")
    public ResponseEntity<?> buscarCompra(@PathVariable Long id){
        return service.buscarIdCompra(id);
    }


}

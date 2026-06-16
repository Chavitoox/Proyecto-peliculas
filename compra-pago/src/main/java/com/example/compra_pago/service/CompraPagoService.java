package com.example.compra_pago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.compra_pago.client.CompraPagoCliente;
import com.example.compra_pago.model.CompraPago;
import com.example.compra_pago.repository.CompraPagoRepository;

@Service
public class CompraPagoService {
    
    @Autowired
    private CompraPagoRepository repo;

    @Autowired
    private CompraPagoCliente  compraClient;

    public ResponseEntity<?> guardar(CompraPago p){
        
        try{
            Object Compra = compraClient.buscarIdCompra(p.getIdCompra());

            if(Compra==null){
                return ResponseEntity.badRequest().body("La compra No existe en el Carrito");

            }

            return ResponseEntity.ok(repo.save(p));


        } catch (Exception e){
            return ResponseEntity.status(404).body("Error al Conectar con CarritoCompra");
        }
    }

    public ResponseEntity<?> listar() {
    List<CompraPago> lista = repo.findAll();
    
    if (lista.isEmpty()) {
        return ResponseEntity.badRequest().body("No hay pagos registrados");
    }

    return ResponseEntity.ok(lista);
}

    public ResponseEntity<?> eliminar(long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body("Pago de la compra no Encontrado!");
        }

        repo.deleteById(id);
        return ResponseEntity.ok("Pago Eliminado Correctamente");
    }

}    

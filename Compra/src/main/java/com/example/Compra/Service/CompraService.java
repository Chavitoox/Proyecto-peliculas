package com.example.Compra.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Compra.Client.PeliculaClient;
import com.example.Compra.Model.Compra;
import com.example.Compra.Repository.CompraRepository;
@Service

public class CompraService {
    
    @Autowired
    private CompraRepository repo;

    @Autowired
    private PeliculaClient peliculaClient;

    public ResponseEntity<?> registrarCompra(@RequestBody Compra c){


        if(c.getPrecio() <= 0){
            return ResponseEntity.badRequest()
            .body("la Compra No puede tener un valor de 0!");
        }

        try{

            Object pelicula  = peliculaClient.buscarPelicula(c.getIdPelicula());

            if(pelicula == null){
                
                return ResponseEntity.badRequest()
                .body("La Pelicula No existe, Compra Invalida");
            }

            return ResponseEntity.ok(repo.save(c)); //Guarda los if y el try
            

        } catch (Exception e){

            return ResponseEntity.internalServerError()
            .body("Error al Conectarse con Peliculas-Service"); 
            //Valida 
            // que se conecte a pelicula
        }

    }

    public ResponseEntity<?> listarCompras(){

        return ResponseEntity.ok(repo.findAll());
    }


    public ResponseEntity<?> eliminarCompra(@PathVariable Long id){
        Compra existe = repo.findById(id).orElse(null);
        if(existe == null){
            return ResponseEntity.badRequest().body("Compra no Encontrada!");
        }

        repo.deleteById(id);
        return ResponseEntity.ok().body("Compra Eliminada Correctamente");
    }

    public ResponseEntity<?> buscarIdCompra(@PathVariable Long id){
        Compra existe = repo.findById(id).orElse(null);
        if(existe == null){
            return ResponseEntity.badRequest().body("Compra no Encontrada!");
        }

        return ResponseEntity.ok().body(repo.findById(id));

    }



    public ResponseEntity<?> actualizarCompra(@RequestBody Compra c, @PathVariable Long id){
        Compra existe = repo.findById(id).orElse(null);
        if(existe == null){
            return ResponseEntity.badRequest().body("Compra no Encontrada!");
        }

        if(c.getPrecio() <= 0){
            return ResponseEntity.badRequest()
            .body("la Compra No puede tener un valor de 0!");
        }
        
        try{

            Object pelicula  = peliculaClient.buscarPelicula(c.getIdPelicula());

            if(pelicula == null){
                
                return ResponseEntity.badRequest()
                .body("La Pelicula No existe, Compra Invalida");
            }


            existe.setPrecio(c.getPrecio());
            existe.setIdPelicula(c.getIdPelicula());

            
            return ResponseEntity.ok(repo.save(existe));



             } catch (Exception e){

            return ResponseEntity.internalServerError()
            .body("Error al Conectarse con Peliculas-Service"); 
            
        }

    }
         
}

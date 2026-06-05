package com.example.Compra.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "Pelicula", url = "http://localhost:8083")
public interface PeliculaClient {

    
    @GetMapping("/peliculas/detalle/{id}")
    Object buscarPelicula(@PathVariable("id") Long id);
}
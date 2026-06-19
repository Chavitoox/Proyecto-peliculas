package com.example.pelicula.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="director", url="${servicio.director.url}")
public interface DirectorClient {
    @GetMapping("/directores/{id}") // Agregué el '/' inicial por buena práctica
    Object buscarDirector(@PathVariable String id);
}
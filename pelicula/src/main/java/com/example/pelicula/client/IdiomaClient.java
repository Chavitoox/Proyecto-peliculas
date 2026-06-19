package com.example.pelicula.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="idioma", url="${servicio.idioma.url}")
public interface IdiomaClient {
    @GetMapping("/idiomas/{id}") // Agregué el '/' inicial por buena práctica
    Object buscarIdioma(@PathVariable String id);
}
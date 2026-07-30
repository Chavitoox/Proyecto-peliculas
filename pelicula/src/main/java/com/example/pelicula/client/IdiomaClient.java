package com.example.pelicula.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "idioma-service", url = "http://idioma-service:8080")
public interface IdiomaClient {


    @GetMapping("/idiomas/{id}")
    Object buscarIdioma(@PathVariable("id") Long id);
}

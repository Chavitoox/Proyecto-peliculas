package com.example.pelicula.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="idioma", url="http://localhost:8082")
public interface IdiomaClient {
    @GetMapping("idiomas/{id}")
    Object buscarIdioma(@PathVariable String id);
}


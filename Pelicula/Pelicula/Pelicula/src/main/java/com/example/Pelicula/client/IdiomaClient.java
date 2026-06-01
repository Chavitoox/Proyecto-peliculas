package com.example.Pelicula.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Idioma", url= "http://localhost:8082")
public interface IdiomaClient {
    @GetMapping("/Idioma/{id}")
    Object buscarIdioma(@PathVariable String id);
}


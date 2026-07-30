package com.example.resenia.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "pelicula-service", url ="http://pelicula-service:8083/peliculas")
public interface PeliculaClient {
    @GetMapping("/{id}")
    Object buscarPorId(@PathVariable("id") Long id);
}

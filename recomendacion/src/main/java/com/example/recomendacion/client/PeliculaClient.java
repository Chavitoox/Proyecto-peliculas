package com.example.recomendacion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.recomendacion.config.RecomendacionConfig;
import com.example.recomendacion.dto.PeliculaResponse;

@FeignClient(
    name = "pelicula-service", 
    url = "http://pelicula-service:8083",
    configuration = RecomendacionConfig.class
)
public interface PeliculaClient {

    @GetMapping("/peliculas/{id}")
    PeliculaResponse getPeliculaById(@PathVariable("id") Long id);
}
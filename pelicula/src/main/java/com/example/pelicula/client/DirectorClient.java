package com.example.pelicula.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="director", url="http://director-service:8082")
public interface DirectorClient{
    @GetMapping("/directores/{id}")
    Object buscarDirector(@PathVariable("id") Long id);
}
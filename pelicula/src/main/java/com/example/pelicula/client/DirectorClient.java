package com.example.pelicula.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="director", url="http://localhost:8081")
public interface DirectorClient{
    @GetMapping("directores/{id}")
    Object buscarDirector(@PathVariable String id);
}

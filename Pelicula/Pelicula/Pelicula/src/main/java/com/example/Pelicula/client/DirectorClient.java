package com.example.Pelicula.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Director",url = "http://localhost:8081")
public interface DirectorClient {
      @GetMapping("/director/{id}")
    Object buscarDirector(@PathVariable String id);
}


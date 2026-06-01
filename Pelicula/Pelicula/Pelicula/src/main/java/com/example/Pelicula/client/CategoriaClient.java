package com.example.Pelicula.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Categoria",url = "http://localhost:8080")
public interface CategoriaClient {
     @GetMapping("/categorias/{id}")
    Object buscarCategoria(@PathVariable String id);
}

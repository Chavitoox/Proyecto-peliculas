package com.example.pelicula.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="categoria", url="${servicio.categoria.url}")
public interface CategoriaClient {
    @GetMapping("/categorias/{id}")
    Object buscarCategoria(@PathVariable String id);
}
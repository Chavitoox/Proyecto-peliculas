package com.example.recomendacion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service", url = "http://usuario-service:8085")
public interface UsuarioClient {

    @GetMapping("/usuarios/{id}")
    Object buscarPorId(@PathVariable("id") Long id);
}
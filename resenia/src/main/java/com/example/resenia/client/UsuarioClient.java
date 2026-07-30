package com.example.resenia.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "usuario-service", url = "http://usuario-service:8085/usuarios")
public interface UsuarioClient {
    @GetMapping("/{id}")
    Object buscarPorId(@PathVariable("id") Long id);
}

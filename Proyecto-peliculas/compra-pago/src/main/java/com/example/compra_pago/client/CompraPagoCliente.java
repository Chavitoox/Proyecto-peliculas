package com.example.compra_pago.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Compra", url = "http://localhost:8084/compras")
public interface CompraPagoCliente {

    @GetMapping("/compra/{id}")
    Object buscarIdCompra(@PathVariable("id") Long id);
}

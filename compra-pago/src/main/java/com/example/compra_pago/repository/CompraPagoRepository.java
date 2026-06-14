package com.example.compra_pago.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.compra_pago.model.CompraPago;


public interface  CompraPagoRepository extends JpaRepository<CompraPago, Long>{
    
}

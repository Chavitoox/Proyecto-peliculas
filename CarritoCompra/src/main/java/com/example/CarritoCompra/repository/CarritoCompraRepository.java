package com.example.CarritoCompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CarritoCompra.model.CarritoCompra;

public interface CarritoCompraRepository  extends JpaRepository<CarritoCompra, Long>{
    
}

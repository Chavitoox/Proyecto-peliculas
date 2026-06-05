package com.example.Compra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Compra.Model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{
    
}

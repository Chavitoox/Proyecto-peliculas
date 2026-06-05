package com.example.Compra.Model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Compra {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Long idCompra;
   @CreationTimestamp
   @JsonFormat(pattern = "yyyy-MM-dd HH:00") 
   private LocalDateTime fechaCompra;
   private double precio;
   private Long idPelicula;

   public Compra() {
   }

   public long getId() {
      return this.idCompra;
   }

   public void setIdCompra(long idCompra) {
      this.idCompra = idCompra;
   }

   public LocalDateTime getFechaCompra() {
      return this.fechaCompra;
   }

   public void setFechaCompra(LocalDateTime fechaCompra) {
      this.fechaCompra = fechaCompra;
   }

   public double getPrecio() {
      return this.precio;
   }

   public void setPrecio(double precio) {
      this.precio = precio;
   }

   public Long getIdPelicula() {
      return this.idPelicula;
   }

   public void setIdPelicula(Long idPelicula) {
      this.idPelicula = idPelicula;
   }
}

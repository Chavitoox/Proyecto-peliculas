package com.example.CarritoCompra.model;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarritoCompra {

   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Long id;
   @CreationTimestamp
   private double precio;
   private Long idPelicula;

   public CarritoCompra() {
   }

   public long getId() {
      return this.id;
   }

   public void setIdCompra(long idCompra) {
      this.id = idCompra;
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



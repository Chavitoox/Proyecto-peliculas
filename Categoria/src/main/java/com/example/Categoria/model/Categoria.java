package com.example.Categoria.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "El nombre de la categoria no puede estar vacio")
    private String nombreCategoria;

    public Categoria (){}

    public long getId(){
        return id;
    }

    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria=nombreCategoria;
    }
    public String getNombreCategoria(){
        return nombreCategoria;
    }
    
}

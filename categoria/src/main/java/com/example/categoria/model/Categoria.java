package com.example.categoria.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "categorias")
public class Categoria {
    @Id
    private String idCategoria;
    private String nombreCategoria;

    public Categoria(){
    }
    public Categoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }

    public String getIdCategoria(){
        return idCategoria;
    }
    public String getNombreCategoria(){
        return nombreCategoria;
    }

    public void setIdCategoria(String idCategoria){
        this.idCategoria = idCategoria;
    }
    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }
}

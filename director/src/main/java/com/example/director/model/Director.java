package com.example.director.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "directores")
public class Director {
    @Id
    private String idDirector;
    private String nombreDirector;
    private String nacionalidad;

    public Director() {
    };

    public Director(String nombreDirector, String nacionalidad){
        this.nombreDirector = nombreDirector;
        this.nacionalidad = nacionalidad;
    }

    public String getIdDirector(){
        return idDirector;
    }
    public String getNombreDirector(){
        return nombreDirector;
    }
    public String getNacionalidad(){
        return nacionalidad;
    }

    public void setIdDirector(String idDirector){
        this.idDirector = idDirector;
    }
    public void setNombreDirector(String nombreDirector){
        this.nombreDirector = nombreDirector;
    }
    public void setNacionalidad(String nacionalidad){
        this.nacionalidad = nacionalidad;
    }

}
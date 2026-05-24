package com.example.Director.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Director {
    @Id
    private String id;
    private String nombre;
    private String nacionalidad;


    public Director (){};

    public String getId(){return id;}
    public void setId(String id){this.id=id;}

    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}

    public String getNacionalidad(){return nacionalidad;}
    public void setNacionalidad(String nacionalidad){this.nacionalidad=nacionalidad;}

}   

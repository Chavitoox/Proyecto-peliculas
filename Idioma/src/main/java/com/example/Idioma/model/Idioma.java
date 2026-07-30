package com.example.Idioma.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "La version no puede estar vacia")
    private String version;
    @NotBlank(message = "el lenguaje no puede estar vacio")
    private String lenguaje;

    public Idioma(){}

    public long getId(){
        return id;
    }
    public String getVersion(){
        return version;
    }
    public void setVersion(String version){
        this.version=version;
    }
    public String getLenguaje(){
        return lenguaje;
    }
    public void setLenguaje(String lenguaje){
        this.lenguaje=lenguaje;
    }
}
package com.example.pelicula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank(message = "El nombre de la pelicula no puede estar vacio")
    private String nombre;
    @Min(value = 1,message = "La duración de la pelicula debe ser mayor a 0")
    private int duracion;
    @Min(value = 1900, message = "El año de la pelicula debe ser mayor a 1900")
    private int anio;
    @NotBlank(message = "El id del idioma no puede estar vacio")
    private String idIdioma;
    @NotBlank(message = "El id del director no puede estar vacio")
    private String idDirector;
    @NotBlank(message = "El id de la categoria no puede estar vacio")
    private String idCategoria;

    public Pelicula() {
    }
    public long getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(String idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(String idDirector) {
        this.idDirector = idDirector;
    }

    public String getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(String idCategoria){
        this.idCategoria=idCategoria;
    }

}

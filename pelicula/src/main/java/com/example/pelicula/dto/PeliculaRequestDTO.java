package com.example.pelicula.dto;

import com.example.pelicula.model.Pelicula;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class PeliculaRequestDTO {

    @NotNull(message = "El objeto película no puede venir nulo")
    @Valid 
    private Pelicula pelicula;
    @NotEmpty(message ="El id de categoria no puede estar vacia")
    private List<Long> idsCategorias;
    @NotEmpty(message = "El id de idiomas no puede estar vacio")
    private List<Long> idsIdiomas;


    public PeliculaRequestDTO() {
    }


    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public List<Long> getIdsCategorias() {
        return idsCategorias;
    }

    public void setIdsCategorias(List<Long> idsCategorias) {
        this.idsCategorias = idsCategorias;
    }

    public List<Long> getIdsIdiomas() {
        return idsIdiomas;
    }

    public void setIdsIdiomas(List<Long> idsIdiomas) {
        this.idsIdiomas = idsIdiomas;
    }
}
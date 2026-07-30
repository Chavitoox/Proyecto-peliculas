package com.example.pelicula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class PeliculaIdioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El id de la película no puede estar vacío")
    private Long idPelicula;

    @NotNull(message = "El id del idioma no puede estar vacío")
    private Long idIdioma;

    public PeliculaIdioma() {
    }

    public PeliculaIdioma(Long idPelicula, Long idIdioma) {
        this.idPelicula = idPelicula;
        this.idIdioma = idIdioma;
    }

    public Long getId() {
        return id;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }
}
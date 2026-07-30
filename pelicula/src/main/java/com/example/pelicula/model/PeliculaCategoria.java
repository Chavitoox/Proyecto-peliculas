package com.example.pelicula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class PeliculaCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El id de la película no puede estar vacío")
    private Long idPelicula;

    @NotNull(message = "El id de la categoría no puede estar vacío")
    private Long idCategoria;

    public PeliculaCategoria() {
    }

    public PeliculaCategoria(Long idPelicula, Long idCategoria) {
        this.idPelicula = idPelicula;
        this.idCategoria = idCategoria;
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}

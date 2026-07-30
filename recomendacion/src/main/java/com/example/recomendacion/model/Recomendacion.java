package com.example.recomendacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "recomendacion")
public class Recomendacion {
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID de usuario es obligatorio")
    @Min(value = 1, message = "El idUsuario debe ser mayor o igual a 1")
    private Long idUsuario;

    @NotNull(message = "El ID de la película es obligatorio")
    @Min(value = 1, message = "El idPelicula debe ser mayor o igual a 1")
    private Long idPelicula;

    @NotBlank(message = "El nombre de la película no puede estar en blanco")
    private String nombrePelicula;

    @NotBlank(message = "La razón o motivo de la recomendación no puede estar en blanco")
    private String razon;



    public long getId(){return id;}
    public void setId(long id){this.id =id;}

    public String getNombrePelicula(){return nombrePelicula;}
    public void setNombrePelicula(String nombrePelicula){this.nombrePelicula=nombrePelicula;}

    public String getRazon(){return razon;}
    public void setRazon(String razon){this.razon=razon;}

    public long getIdPelicula(){return idPelicula;}
    public void setIdPelicula(long idPelicula){this.idPelicula=idPelicula;}

    public long getIdUsuario(){return idUsuario;}
    public void setIdUsuario(long IdUsuario){this.idUsuario= IdUsuario;}

}

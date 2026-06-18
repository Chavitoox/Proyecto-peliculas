package com.example.compra_pago.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
public class CompraPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message="La forma de pago es Obligatoria")
    private String formaPago;
    @NotNull(message= "El total de la Compra es Obligatorio")
    @Positive(message= "El total de la Compra debe Ser Mayor a Cero")
    private double total;
    private long idCompra;
    @CreationTimestamp
    private LocalDateTime fechaPago;



    //Getters y Setters
    public CompraPago(){}
    

    public Long getId(){return id;}
    public void setId(long id){this.id=id;}

    public String getFormaPago(){return formaPago;}
    public void setFormaPago(String formaPago){this.formaPago=formaPago;}

    public double getTotal(){return total;}

    public void setTotal(double total){this.total=total;}


    public Long getIdCompra(){return idCompra;}
    public void setIdCompra(Long idCompra){this.idCompra=idCompra;}
    
    public LocalDateTime getFechaPago(){return fechaPago;}
    public void setFechaPago(LocalDateTime fechaPago){this.fechaPago=fechaPago;}
}



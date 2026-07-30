package com.example.recomendacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recomendacion.client.PeliculaClient;
import com.example.recomendacion.dto.PeliculaResponse;
import com.example.recomendacion.exception.NombrePeliculaException;
import com.example.recomendacion.exception.RecursoNoEncontradoException;
import com.example.recomendacion.model.Recomendacion;
import com.example.recomendacion.repository.RecomendacionRepository;

import feign.FeignException;

@Service
public class RecomendacionService {
    @Autowired
    private RecomendacionRepository repo;

    @Autowired
    private PeliculaClient peliculaClient;

    public List<Recomendacion> listar(){
        return repo.findAll();
    }

    public Recomendacion buscarPorId(Long id){
        return repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Recomendacion no encontrada"));
    }

    public Recomendacion crear(Recomendacion r){
        validarPelicula(r.getIdPelicula(), r.getNombrePelicula());
        return repo.save(r);
    }

    public Recomendacion actualizar(Long id, Recomendacion r){
        Recomendacion existe = repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Recomendacion no encontrada"));

        validarPelicula(r.getIdPelicula(), r.getNombrePelicula());

        existe.setRazon(r.getRazon());
        existe.setIdUsuario(r.getIdUsuario());
        existe.setIdPelicula(r.getIdPelicula());
        existe.setNombrePelicula(r.getNombrePelicula());

        return repo.save(existe);
    }

    public void eliminar(Long id){
        repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Recomendacion no encontrada"));
        repo.deleteById(id);
    }

    private void validarPelicula(long idPelicula, String nombrePelicula){
        PeliculaResponse pelicula;
        try {
            pelicula = peliculaClient.getPeliculaById(idPelicula);
        } catch (FeignException.NotFound e) {
            throw new RecursoNoEncontradoException("Pelicula no encontrada con id " + idPelicula);
        }

        if (!pelicula.nombre().equalsIgnoreCase(nombrePelicula)) {
            throw new NombrePeliculaException(
                "El nombre '" + nombrePelicula + "' no coincide con la película registrada (id " + idPelicula + ": '" + pelicula.nombre() + "')"
            );
        }
    }
}
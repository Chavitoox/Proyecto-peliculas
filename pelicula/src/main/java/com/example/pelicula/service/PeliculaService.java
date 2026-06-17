package com.example.pelicula.service;

import com.example.pelicula.model.Pelicula;
import com.example.pelicula.exception.RecursoNoEncontradoException;
import com.example.pelicula.client.*;
import com.example.pelicula.repository.PeliculaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.HashMap;
@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository repo;

    @Autowired
    private IdiomaClient idiomaClient;

    @Autowired
    private DirectorClient directorClient;

    @Autowired
    private CategoriaClient categoriaClient;

    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(repo.findAll());
    }

    public ResponseEntity<?> buscarPorId(Long id){
        return ResponseEntity.ok().body(repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Pelicula no encontrada")));
    }

    public Pelicula crear(Pelicula p) {
        if (repo.existsByNombre(p.getNombre())) {
            throw new RecursoNoEncontradoException("Una pelicula con el nombre '" + p.getNombre() + "' ya existe");
        }
        
        idiomaClient.buscarIdioma(p.getIdIdioma());
        categoriaClient.buscarCategoria(p.getIdCategoria());
        directorClient.buscarDirector(p.getIdDirector());

        return repo.save(p);
    }

    public ResponseEntity<?> actualizar(Long id, Pelicula p) {
        Pelicula Existe = repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Pelicula no encontrada"));

        if(repo.existsByNombre(p.getNombre()) && !Existe.getNombre().equals(p.getNombre())){
            return ResponseEntity.badRequest().body("Una pelicula con ese nombre ya existe");
        }

        Existe.setNombre(p.getNombre());
        Existe.setAnio(p.getAnio());
        Existe.setDuracion(p.getDuracion());

        return ResponseEntity.ok().body(repo.save(Existe));
    }

    public ResponseEntity<?>Eliminar(Long id){
        repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Pelicula no encontrada"));

        repo.deleteById(id);
        return ResponseEntity.ok().body("Pelicula Eliminada correctamente");
    }

    public ResponseEntity <?> mostrarDetalle(Long id){
        try {
            Pelicula p = repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Pelicula no encontrada"));

            Object idioma = idiomaClient.buscarIdioma(p.getIdIdioma());
            Object director = directorClient.buscarDirector(p.getIdDirector());
            Object categoria = categoriaClient.buscarCategoria(p.getIdCategoria());

            Map<String, Object> Respuesta = new HashMap<>();

            Respuesta.put("id",p.getId());
            Respuesta.put("nombre", p.getNombre());
            Respuesta.put("año",p.getAnio());
            Respuesta.put("Duracion",p.getDuracion());
            Respuesta.put("datosIdioma",idioma);
            Respuesta.put("datosDirector",director);
            Respuesta.put("datosCategoria",categoria);

            return ResponseEntity.ok(Respuesta);
            
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("error detallado" + e.getMessage());
        }

    }
}


package com.example.Pelicula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.example.Pelicula.Model.Pelicula;
import com.example.Pelicula.Repository.PeliculaRepository;
import com.example.Pelicula.client.IdiomaClient;
import com.example.Pelicula.client.DirectorClient;
import com.example.Pelicula.client.CategoriaClient;
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

    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(repo.findAll());
    }

    public ResponseEntity<?> crear(@RequestBody Pelicula p) {
        List<Pelicula> Existe = repo.findByNombre(p.getNombre());
        if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de la pelicula no puede estar vacia");
        }
        if (p.getDuracion() < 0) {
            return ResponseEntity.badRequest().body("La duracion debe ser mayor a 0");
        }
        if (p.getAnio() < 0) {
            return ResponseEntity.badRequest().body("el año debe ser mayor a 0");
        }
        if (!Existe.isEmpty()) {
            return ResponseEntity.badRequest().body("Pelicula Ya existente");
        }

        Pelicula guardada = repo.save(p);
        return ResponseEntity.ok(guardada);
    }

    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Pelicula p) {
        Pelicula Existe = repo.findById(id).orElse(null);
        List<Pelicula> Existente = repo.findByNombre(p.getNombre());
        if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de la pelicula no puede estar vacia");
        }
        if (p.getDuracion() < 0) {
            return ResponseEntity.badRequest().body("La duracion debe ser mayor a 0");
        }
        if (p.getAnio() < 0) {
            return ResponseEntity.badRequest().body("el año debe ser mayor a 0");
        }
        if (!Existente.isEmpty()) {
            return ResponseEntity.badRequest().body("Pelicula Ya existente");
        }

        Existe.setNombre(p.getNombre());
        Existe.setAnio(p.getAnio());
        Existe.setDuracion(p.getDuracion());

        return ResponseEntity.ok().body(Existe);
    }

    public ResponseEntity<?> Eliminar(@PathVariable Long id) {
        Pelicula Existe = repo.findById(id).orElse(null);

        if (Existe == null) {
            return ResponseEntity.badRequest().body("Pelicula no encontrada");
        }
        repo.deleteById(id);
        return ResponseEntity.ok().body("Pelicula Eliminada correctamente");
    }

    public ResponseEntity<?> guardarIdioma(Pelicula p) {
        List<Pelicula> Existe = repo.findByNombre(p.getNombre());
                    if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de la pelicula no puede estar vacia");
        }
        if (p.getDuracion() < 0) {
            return ResponseEntity.badRequest().body("La duracion debe ser mayor a 0");
        }
        if (p.getAnio() < 0) {
            return ResponseEntity.badRequest().body("el año debe ser mayor a 0");
        }
        if (!Existe.isEmpty()) {
            return ResponseEntity.badRequest().body("Pelicula Ya existente");
        }
                if (p.getIdIdioma() == null || p.getIdIdioma().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El id de la pelicula no puede estar vacia");
        }


        try {
            Object idioma = idiomaClient.buscarIdioma(p.getIdIdioma());


            if (idioma == null || p.getIdIdioma().isEmpty()) {
                return ResponseEntity.badRequest().body("El idioma no existe");
             
            }
            Object categoria = categoriaClient.buscarCategoria(p.getIdCategoria());
            if (categoria == null) {
                return ResponseEntity.badRequest().body("la categoria no existe");
            }
            Object director = directorClient.buscarDirector(p.getIdDirector());
            if (director == null) {
                return ResponseEntity.badRequest().body("el director no existe");
            }

            return ResponseEntity.ok(repo.save(p));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al comunicar con microservicios");
        }



        
    }

    public ResponseEntity<?> mostrarDatos(Long id) {
        try {
            Pelicula p = repo.findById(id).orElse(null);
            if (p == null) {
                return ResponseEntity.badRequest().body("la pelicula no existe");

            }
            Object idioma = idiomaClient.buscarIdioma(p.getIdIdioma());
            Object director = directorClient.buscarDirector(p.getIdDirector());
            Object categoria = categoriaClient.buscarCategoria(p.getIdCategoria());

            Map<String, Object> Respuesta = new HashMap<>();

            Respuesta.put("id", p.getId());
            Respuesta.put("nombre", p.getNombre());
            Respuesta.put("año", p.getAnio());
            Respuesta.put("Duracion", p.getDuracion());
            Respuesta.put("datosIdioma", idioma);
            Respuesta.put("datosDirector", director);
            Respuesta.put("datosCategoria", categoria);

            return ResponseEntity.ok(Respuesta);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("error detallado" + e.getMessage());
        }

    }

}

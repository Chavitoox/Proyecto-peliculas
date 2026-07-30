package com.example.pelicula.service;

import com.example.pelicula.model.Pelicula;
import com.example.pelicula.model.PeliculaCategoria;
import com.example.pelicula.model.PeliculaIdioma;
import com.example.pelicula.dto.PeliculaRequestDTO;
import com.example.pelicula.exception.RecursoNoEncontradoException;
import com.example.pelicula.client.DirectorClient;
import com.example.pelicula.client.CategoriaClient;
import com.example.pelicula.client.IdiomaClient;
import com.example.pelicula.repository.PeliculaRepository;
import com.example.pelicula.repository.PeliculaCategoriaRepository;
import com.example.pelicula.repository.PeliculaIdiomaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository repo;

    @Autowired
    private DirectorClient directorClient;

    @Autowired
    private CategoriaClient categoriaClient;

    @Autowired
    private IdiomaClient idiomaClient;

    @Autowired
    private PeliculaCategoriaRepository peliculaCategoriaRepo;

    @Autowired
    private PeliculaIdiomaRepository peliculaIdiomaRepo;

    public List<Pelicula> listar() {
        return repo.findAll();
    }

    public Pelicula buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Pelicula no encontrada"));
    }

    public Pelicula crear(PeliculaRequestDTO dto) {
        Pelicula p = dto.getPelicula();

        if (repo.existsByNombre(p.getNombre())) {
            throw new RecursoNoEncontradoException("Una película con ese nombre ya existe");
        }

        try {
            directorClient.buscarDirector(p.getIdDirector());
        } catch (feign.FeignException.NotFound e) {
            throw new RecursoNoEncontradoException("El director con ID " + p.getIdDirector() + " no existe");
        } catch (Exception e) {
            throw new RecursoNoEncontradoException("Error al conectar con el microservicio de Directores");
        }

        if (dto.getIdsCategorias() != null) {
            for (Long idCat : dto.getIdsCategorias()) {
                try {
                    categoriaClient.buscarCategoria(idCat);
                } catch (feign.FeignException.NotFound e) {
                    throw new RecursoNoEncontradoException("La categoría con ID " + idCat + " no existe");
                } catch (Exception e) {
                    throw new RecursoNoEncontradoException("Error al conectar con el microservicio de Categorías");
                }
            }
        }

        if (dto.getIdsIdiomas() != null) {
            for (Long idIdi : dto.getIdsIdiomas()) {
                try {
                    idiomaClient.buscarIdioma(idIdi);
                } catch (feign.FeignException.NotFound e) {
                    throw new RecursoNoEncontradoException("El idioma con ID " + idIdi + " no existe");
                } catch (Exception e) {
                    throw new RecursoNoEncontradoException("Error al conectar con el microservicio de Idiomas");
                }
            }
        }

        Pelicula peliculaGuardada = repo.save(p);

        // 6. Guardamos los cruces en la tabla intermedia pelicula_categoria
        if (dto.getIdsCategorias() != null) {
            for (Long idCat : dto.getIdsCategorias()) {
                // Usamos el ID autogenerado de la peli que acabamos de guardar
                PeliculaCategoria pc = new PeliculaCategoria(peliculaGuardada.getId(), idCat);
                peliculaCategoriaRepo.save(pc);
            }
        }

        // 7. Guardamos los cruces en la tabla intermedia pelicula_idioma
        if (dto.getIdsIdiomas() != null) {
            for (Long idIdi : dto.getIdsIdiomas()) {
                PeliculaIdioma pi = new PeliculaIdioma(peliculaGuardada.getId(), idIdi);
                peliculaIdiomaRepo.save(pi);
            }
        }

        return peliculaGuardada;
    }

    public Pelicula actualizar(Long id, Pelicula p) {
        Pelicula existe = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Pelicula no encontrada"));

        if (repo.existsByNombre(p.getNombre()) && !existe.getNombre().equals(p.getNombre())) {
            throw new RecursoNoEncontradoException("Una película con ese nombre ya existe");
        }
        try {
            directorClient.buscarDirector(p.getIdDirector());

            existe.setNombre(p.getNombre());
            existe.setAnio(p.getAnio());
            existe.setDuracion(p.getDuracion());
            existe.setIdDirector(p.getIdDirector());
            return repo.save(existe);

        } catch (feign.FeignException.NotFound e) {
            throw new RecursoNoEncontradoException("El director con ID " + p.getIdDirector() + " no existe");
        } catch (Exception e) {
            throw new RecursoNoEncontradoException("Error al conectar con el microservicio de Directores");
        }
    }

    public void eliminar(Long id) {
        repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Pelicula no encontrada"));
        repo.deleteById(id);
    }
}
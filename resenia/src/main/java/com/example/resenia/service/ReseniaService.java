package com.example.resenia.service;

import com.example.resenia.model.Resenia;
import com.example.resenia.client.PeliculaClient;
import com.example.resenia.client.UsuarioClient;
import com.example.resenia.repository.ReseniaRepository;
import com.example.resenia.exception.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseniaService {

    @Autowired
    private ReseniaRepository repo;

    @Autowired
    private PeliculaClient peliculaClient;

    @Autowired
    private UsuarioClient usuarioClient;

    public List<Resenia> listar() {
        return repo.findAll();
    }

    public List<Resenia> listarPorPelicula(Long idPelicula) {
        return repo.findByIdPelicula(idPelicula);
    }

    public Resenia crear(Resenia r) {
        try {
            peliculaClient.buscarPorId(r.getIdPelicula());
        } catch (feign.FeignException.NotFound e) {
            throw new RecursoNoEncontradoException("La película con ID " + r.getIdPelicula() + " no existe. No se puede crear la reseña.");
        } catch (Exception e) {
            throw new RecursoNoEncontradoException("Error al conectar con el microservicio de Películas");
        }

        try {
            usuarioClient.buscarPorId(r.getIdUsuario());
        } catch (feign.FeignException.NotFound e){
            throw new RecursoNoEncontradoException("El usuario con el id " + r.getIdUsuario() + " no existe. No se puede crear la reseña.");
        } catch (Exception e){
            throw new RecursoNoEncontradoException("Error al conectar con el microservicio de usuarios");
        }

        return repo.save(r);
    }

    public void eliminar(Long id) {
        repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Reseña no encontrada"));
        repo.deleteById(id);
    }
}
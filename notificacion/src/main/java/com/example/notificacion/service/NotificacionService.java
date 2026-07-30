package com.example.notificacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notificacion.client.UsuarioClient;
import com.example.notificacion.exception.RecursoNoEncontradoException;
import com.example.notificacion.model.Notificacion;
import com.example.notificacion.repository.NotificacionRepository;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository repo;

    @Autowired
    private UsuarioClient usuarioclient;

    public List<Notificacion> listar() {
        return repo.findAll();
    }

    public Notificacion buscarPorId(Long id){
        return repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Notificacion no encontrado"));
    }
    public Notificacion crear(Notificacion n) {

        try {
            usuarioclient.buscarPorId(n.getIdUsuario());
        } catch (feign.FeignException.NotFound e) {
            throw new RecursoNoEncontradoException(
                    "El usuario con ID " + n.getIdUsuario() + " no existe. No se puede crear la Notificacion.");
        } catch (Exception e) {
            throw new RecursoNoEncontradoException("Error al conectar con el microservicio de Usuario");
        }
        return repo.save(n);
    }

    public void eliminar(Long id) {
        repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Notificacion no encontrada"));
        repo.deleteById(id);

    }
}

package com.example.usuario.service;

import com.example.usuario.repository.UsuarioRepository;
import com.example.usuario.exception.RecursoNoEncontradoException;
import com.example.usuario.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> listar(){
        return repo.findAll();
    }

    public Usuario buscarPorId(Long id){
        return repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Usuario no encontrado"));
    }

    public Usuario crear(Usuario u){
        if(repo.existsByCorreo(u.getCorreo())){
            throw new RecursoNoEncontradoException("El correo ingresado ya existe");
        }
        return repo.save(u);
    }

    public Usuario actualizar(Long id, Usuario u){
        Usuario existe = repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Usuario no encontrado"));


        existe.setNombreUsuario(u.getNombreUsuario());
        existe.setEdad(u.getEdad());
        existe.setCorreo(u.getCorreo());

        return repo.save(existe);
    }

    public void eliminar(Long id){
        repo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Usuario no encontrado"));
        repo.deleteById(id);
    }

}

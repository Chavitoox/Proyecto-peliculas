package com.example.usuario.repository;

import com.example.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    boolean existsByCorreo(String correo);
}

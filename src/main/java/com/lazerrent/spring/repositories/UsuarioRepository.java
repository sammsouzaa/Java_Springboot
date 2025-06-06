package com.lazerrent.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lazerrent.spring.domain.usuario.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Query("""
        SELECT u FROM Usuario u 
        JOIN u.usuarioTipos ut 
        JOIN ut.tipoUsuario t 
        WHERE u.auth.email = :email AND t.nome = :tipo
    """)
    Optional<Usuario> findByEmailAndTipo(String email, String tipo);
}


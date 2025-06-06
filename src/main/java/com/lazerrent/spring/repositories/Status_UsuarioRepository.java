package com.lazerrent.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazerrent.spring.domain.usuario.Status_Usuario;

public interface Status_UsuarioRepository extends JpaRepository<Status_Usuario, Integer>{
    
}

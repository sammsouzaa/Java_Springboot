package com.lazerrent.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazerrent.spring.domain.usuario.Tipos_Usuarios;

public interface TipoUsuarioRepository extends JpaRepository<Tipos_Usuarios, Integer>{
    
}

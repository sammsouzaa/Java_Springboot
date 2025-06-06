package com.lazerrent.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazerrent.spring.domain.imovel.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer>{
    
}

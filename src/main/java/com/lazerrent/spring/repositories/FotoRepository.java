package com.lazerrent.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazerrent.spring.domain.imovel.Foto;

public interface FotoRepository extends JpaRepository<Foto, Integer> {
    
}

package com.lazerrent.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazerrent.spring.domain.imovel.Status_Imovel;

public interface Status_ImovelRepository extends JpaRepository<Status_Imovel, Integer>{
    
}

package com.lazerrent.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lazerrent.spring.domain.imovel.Caracteristicas_Basicas;

public interface CaracteristicasRepository extends JpaRepository<Caracteristicas_Basicas, Integer>{

    @Query("SELECT c FROM Caracteristicas_Basicas c WHERE c.imovel.id = :imovelId")
    Optional<Caracteristicas_Basicas> findCaracteristicasByImovelId(@Param("imovelId") Integer imovelId);
    
}

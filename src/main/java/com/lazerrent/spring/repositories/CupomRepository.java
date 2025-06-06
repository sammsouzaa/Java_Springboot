package com.lazerrent.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.lazerrent.spring.domain.cupom.Cupom;

public interface CupomRepository extends JpaRepository<Cupom, String> {
    
    // Consulta para pegar todos os cupons com base no imovel_id
    @Query("SELECT c FROM Cupom c WHERE c.imovel.id = :imovelId")
    Page<Cupom> findCuponsByImovelId(@Param("imovelId") int imovelId, Pageable pageable);

}

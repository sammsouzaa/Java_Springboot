package com.lazerrent.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lazerrent.spring.domain.imovel.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Integer> {

    @Query("""
        SELECT i 
        FROM Imovel i 
        WHERE i.category.categoria = :category 
        AND (:status IS NULL OR :status = '' OR i.status.status = :status OR i.status.status = 'ativo')
    """)
    Page<Imovel> getImovelByCategory(
        @Param("category") String category,
        @Param("status") String status,
        Pageable pageable
    );


    // Consulta para retornar imóveis de acordo com o status
    @Query("SELECT i FROM Imovel i WHERE i.status.status = :status")
    Page<Imovel> getImovelByStatus(@Param("status") String status, Pageable pageable);
}

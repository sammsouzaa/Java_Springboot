package com.lazerrent.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lazerrent.spring.domain.imovel.Endereco_Imovel;

public interface Endereco_ImovelRepository extends JpaRepository<Endereco_Imovel, Integer>{

    @Query("SELECT e FROM Endereco_Imovel e WHERE e.imovel.id = :imovelId")
    Optional<Endereco_Imovel> findEnderecoByImovelId(@Param("imovelId") Integer imovelId);

}

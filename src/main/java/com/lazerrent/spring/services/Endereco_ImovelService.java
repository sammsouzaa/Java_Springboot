package com.lazerrent.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazerrent.spring.domain.imovel.Endereco_Imovel;
import com.lazerrent.spring.domain.imovel.Imovel;
import com.lazerrent.spring.domain.imovel.DTO.ImovelRequestDTO;
import com.lazerrent.spring.repositories.Endereco_ImovelRepository;

@Service
public class Endereco_ImovelService{

    @Autowired
    private Endereco_ImovelRepository repository;

    public Endereco_Imovel createEndereco(ImovelRequestDTO data, Imovel newImovel) {
        
        Endereco_Imovel newEndereco = new Endereco_Imovel();

        newEndereco.setNumero(data.numero());
        newEndereco.setBairro(data.bairro());
        newEndereco.setCep(data.cep());
        newEndereco.setEstado(data.estado());
        newEndereco.setRua(data.rua());
        newEndereco.setCidade(data.cidade());;
        newEndereco.setImovel(newImovel);

        repository.save(newEndereco);

        return newEndereco;
    }

}

package com.lazerrent.spring.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazerrent.spring.domain.imovel.Status_Imovel;
import com.lazerrent.spring.domain.imovel.DTO.StatusImovelResponseDTO;
import com.lazerrent.spring.repositories.Status_ImovelRepository;

@Service
public class Status_ImovelService {

    @Autowired
    private Status_ImovelRepository repository;

    public Status_Imovel createStatus(String status){

        Status_Imovel newStatus_Imovel = new Status_Imovel();

        newStatus_Imovel.setStatus(status);

        repository.save(newStatus_Imovel);

        return newStatus_Imovel;
    }

    public List<StatusImovelResponseDTO> getAllStatus(){

        return repository.findAll().stream()
                .map(status -> new StatusImovelResponseDTO(status.getId(), status.getStatus()))
                .toList();
    }

    public Status_Imovel findStatusById(Integer id) {
        Optional<Status_Imovel> status = repository.findById(id);
        
        return status.orElseThrow(() -> new RuntimeException("Status não encontrado para o ID: " + id));
    }

    public void deleteStatus(Integer id) {
        
        if (repository.existsById(id)) {
            repository.deleteById(id); 
        } else {
            throw new RuntimeException("Status não encontrado");  // Lança exceção caso não encontre o cupom
        }
    }
}

package com.lazerrent.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazerrent.spring.domain.usuario.Status_Usuario;
import com.lazerrent.spring.domain.usuario.DTO.StatusUsuarioResponseDTO;
import com.lazerrent.spring.repositories.Status_UsuarioRepository;

@Service
public class Status_UsuarioService {

    @Autowired
    private Status_UsuarioRepository repository;

    public Status_Usuario createStatus(String status){

        Status_Usuario newStatus_Imovel = new Status_Usuario();

        newStatus_Imovel.setStatus(status);

        repository.save(newStatus_Imovel);

        return newStatus_Imovel;
    }

    public List<StatusUsuarioResponseDTO> getAllStatus(){

        return repository.findAll().stream()
                .map(status -> new StatusUsuarioResponseDTO(status.getId(), status.getStatus()))
                .toList();
    }

    public Status_Usuario findStatusById(Integer id) {
        Optional<Status_Usuario> status = repository.findById(id);
        
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

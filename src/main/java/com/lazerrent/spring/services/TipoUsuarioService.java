package com.lazerrent.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazerrent.spring.domain.usuario.Tipos_Usuarios;
import com.lazerrent.spring.domain.usuario.DTO.TipoUsuarioRequestDTO;
import com.lazerrent.spring.domain.usuario.DTO.TipoUsuarioResponseDTO;
import com.lazerrent.spring.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository repository;

    public Tipos_Usuarios createTipoUsuario( TipoUsuarioRequestDTO data){

        Tipos_Usuarios newTipos_Usuarios = new Tipos_Usuarios();

        newTipos_Usuarios.setNome(data.nome());
        newTipos_Usuarios.setDescricao(data.descricao());

        repository.save(newTipos_Usuarios);

        return newTipos_Usuarios;
    }

    public List<TipoUsuarioResponseDTO> getAllTipoUsuario(){

        return repository.findAll().stream()
                .map(tipo -> new TipoUsuarioResponseDTO(tipo.getId(), tipo.getNome(), tipo.getDescricao()))
                .toList();
    }

    public Tipos_Usuarios findTipoUsuarioById(Integer id) {
        Optional<Tipos_Usuarios> tipo = repository.findById(id);
        
        return tipo.orElseThrow(() -> new RuntimeException("Tipo usuario não encontrado para o ID: " + id));
    }

    public void deleteTipoUsuario(Integer id) {
        
        if (repository.existsById(id)) {
            repository.deleteById(id); 
        } else {
            throw new RuntimeException("Tipo não encontrado");  // Lança exceção caso não encontre o cupom
        }
    }
}

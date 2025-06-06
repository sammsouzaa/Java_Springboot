package com.lazerrent.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazerrent.spring.domain.imovel.Categoria;
import com.lazerrent.spring.domain.imovel.DTO.CategoriaResponseDTO;
import com.lazerrent.spring.domain.imovel.DTO.ImovelRequestDTO;
import com.lazerrent.spring.repositories.CategoriasRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriasRepository repository;

    public Categoria createCategory(String categoria){

        Categoria newCategoria =  new Categoria();

        newCategoria.setCategoria(categoria);

        repository.save(newCategoria);

        return newCategoria; 
    }

    public List<CategoriaResponseDTO> getAllCategories(){

        return repository.findAll().stream()
                .map(categoria -> new CategoriaResponseDTO(categoria.getId(), categoria.getCategoria()))
                .toList();
    }

    public Categoria findCategoryById(ImovelRequestDTO data) {
        Optional<Categoria> categoria = repository.findById(data.idCategoria());
        
        return categoria.orElseThrow(() -> new RuntimeException("Categoria não encontrado para o ID: " + data.idCategoria()));
    }

    public void deleteCategoria(Integer id) {
        
        if (repository.existsById(id)) {
            repository.deleteById(id); 
        } else {
            throw new RuntimeException("Categoria não encontrado");  // Lança exceção caso não encontre o cupom
        }
    }
    
}

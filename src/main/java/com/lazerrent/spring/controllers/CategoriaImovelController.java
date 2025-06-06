package com.lazerrent.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lazerrent.spring.domain.imovel.Categoria;
import com.lazerrent.spring.domain.imovel.DTO.CategoriaResponseDTO;
import com.lazerrent.spring.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria-imovel")
public class CategoriaImovelController {

    @Autowired
    private  CategoriaService categoriaService;

    ///////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////// CATEGORIAS DO IMOVEL /////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(path = "/admin/categorias")
    public ResponseEntity <Categoria> createCategory (@RequestParam String categoria){

        Categoria newCategoria = this.categoriaService.createCategory(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategoria);
    }

    @GetMapping(path = "/admin/categorias")
    public ResponseEntity <List<CategoriaResponseDTO>> getAllCategories(){

        List<CategoriaResponseDTO> listaCategories = this.categoriaService.getAllCategories();
        return ResponseEntity.ok(listaCategories);
    }

    @DeleteMapping(path = "/admin/categorias/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
        this.categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
    
}

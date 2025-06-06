package com.lazerrent.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazerrent.spring.domain.usuario.Tipos_Usuarios;
import com.lazerrent.spring.domain.usuario.DTO.TipoUsuarioRequestDTO;
import com.lazerrent.spring.domain.usuario.DTO.TipoUsuarioResponseDTO;
import com.lazerrent.spring.services.TipoUsuarioService;

@RestController
@RequestMapping("/api/tipo-usuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @PostMapping(path = "/admin/tipos")
    public ResponseEntity <Tipos_Usuarios> createStatus (@RequestBody TipoUsuarioRequestDTO body){

        Tipos_Usuarios tipos_Usuarios = this.tipoUsuarioService.createTipoUsuario(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipos_Usuarios);
    }

    @GetMapping(path = "/admin/tipos")
    public ResponseEntity <List<TipoUsuarioResponseDTO>> getAllStatus_Usuario(){

        List<TipoUsuarioResponseDTO> listaTipos = this.tipoUsuarioService.getAllTipoUsuario();
        return ResponseEntity.ok(listaTipos);
    }

    @DeleteMapping(path = "/admin/tipos/{id}")
    public ResponseEntity deleteStatus(@PathVariable Integer id) {
        this.tipoUsuarioService.deleteTipoUsuario(id);
        return ResponseEntity.noContent().build();
    }
    
}

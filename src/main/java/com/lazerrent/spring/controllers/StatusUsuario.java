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

import com.lazerrent.spring.domain.usuario.Status_Usuario;
import com.lazerrent.spring.domain.usuario.DTO.StatusUsuarioResponseDTO;
import com.lazerrent.spring.services.Status_UsuarioService;

@RestController
@RequestMapping("/api/status-usuario")
public class StatusUsuario {

    @Autowired
    private Status_UsuarioService status_UsuarioService;

    ///////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////// STATUS DO USUARIO //////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(path = "/admin/status")
    public ResponseEntity <Status_Usuario> createStatus (@RequestParam String status){

        Status_Usuario status_Usuario = this.status_UsuarioService.createStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(status_Usuario);
    }

    @GetMapping(path = "/admin/status")
    public ResponseEntity <List<StatusUsuarioResponseDTO>> getAllStatus_Usuario(){

        List<StatusUsuarioResponseDTO> listaStatus = this.status_UsuarioService.getAllStatus();
        return ResponseEntity.ok(listaStatus);
    }

    @DeleteMapping(path = "/admin/status/{id}")
    public ResponseEntity deleteStatus(@PathVariable Integer id) {
        this.status_UsuarioService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }
    
}

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

import com.lazerrent.spring.domain.imovel.Status_Imovel;
import com.lazerrent.spring.domain.imovel.DTO.StatusImovelResponseDTO;
import com.lazerrent.spring.services.Status_ImovelService;

@RestController
@RequestMapping("/api/status-imovel")
public class StatusImovelController {

    @Autowired
    private Status_ImovelService status_ImovelService;

    ///////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////// STATUS DO IMOVEL ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(path = "/admin/status")
    public ResponseEntity <Status_Imovel> createStatus (@RequestParam String status){

        Status_Imovel status_Imovel = this.status_ImovelService.createStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(status_Imovel);
    }

    @GetMapping(path = "/admin/status")
    public ResponseEntity <List<StatusImovelResponseDTO>> getAllStatus_Imovel(){

        List<StatusImovelResponseDTO> listaStatus = this.status_ImovelService.getAllStatus();
        return ResponseEntity.ok(listaStatus);
    }

    @DeleteMapping(path = "/admin/status/{id}")
    public ResponseEntity deleteStatus(@PathVariable Integer id) {
        this.status_ImovelService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }


    
}

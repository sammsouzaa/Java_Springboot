package com.lazerrent.spring.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lazerrent.spring.domain.cupom.DTO.CupomRequestDTO;
import com.lazerrent.spring.domain.cupom.DTO.CupomResponseDTO;
import com.lazerrent.spring.services.CupomService;

@RestController
@RequestMapping("/api/cupom")
public class CupomController {

    @Autowired
    private CupomService cupomService;

    @PostMapping(path = "/proprietario/cupons")
    public ResponseEntity<CupomResponseDTO> gerarCupom(@RequestBody CupomRequestDTO body){

        CupomResponseDTO newCupom = this.cupomService.gerarCupom(body);
        return ResponseEntity.ok(newCupom);
    }

    // criar metodo para usar cupom (mudar status do cupom)
    

    @GetMapping(path = "/admin/cupons")
    public ResponseEntity<List<CupomResponseDTO>> getAllCupons(@RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "10") int size){

        List<CupomResponseDTO> cupons = this.cupomService.getAllCupons(page, size);
        return ResponseEntity.ok(cupons);
    }

    @GetMapping(path = "/proprietario/cupons/{id}")
    public ResponseEntity<List<CupomResponseDTO>> getImovelCupons(@PathVariable Integer id,  @RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "10") int size){

        List<CupomResponseDTO> cupons = this.cupomService.getImovelCupons(id, page, size);
        return ResponseEntity.ok(cupons);
    }

    @DeleteMapping(path = "/admin/cupons/{id}")
    public ResponseEntity deleteCupom(@PathVariable String id) {
        this.cupomService.deleteCupom(id);
        return ResponseEntity.ok("Cupom deletado com sucesso.");
    }
    
}

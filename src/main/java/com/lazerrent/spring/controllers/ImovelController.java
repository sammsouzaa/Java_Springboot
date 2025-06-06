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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lazerrent.spring.domain.imovel.Imovel;
import com.lazerrent.spring.domain.imovel.DTO.ImovelDetailsRespondeDTO;
import com.lazerrent.spring.domain.imovel.DTO.ImovelRequestDTO;
import com.lazerrent.spring.domain.imovel.DTO.ImovelResponseDTO;
import com.lazerrent.spring.services.ImovelService;

@RestController
@RequestMapping("/api/imovel")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    ///////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////// IMOVEIS /////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(path = "/proprietario/imoveis")
    public ResponseEntity<Imovel> createImovel(@RequestBody ImovelRequestDTO body) {
        Imovel novoImovel = this.imovelService.createImovel(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoImovel);
    }

    @GetMapping(path = "/user/imoveis/categorias/{category}/{status}")
    public ResponseEntity<List<ImovelResponseDTO>> getImoveisByCategory (@PathVariable String category, @PathVariable String status, @RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "10") int size){

        List<ImovelResponseDTO> allImoveis = this.imovelService.getImovelByCategory(page, size, category, status);
        return ResponseEntity.ok(allImoveis);
    }

    @GetMapping(path = "/user/imoveis")
    public ResponseEntity<List<ImovelResponseDTO>> getImoveis (@RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "10") int size){

        List<ImovelResponseDTO> allImoveis = this.imovelService.getImovel(page, size);
        return ResponseEntity.ok(allImoveis);
    }

    @GetMapping(path = "/admin/imoveis/status/{status}")
    public ResponseEntity<List<ImovelResponseDTO>> getImoveisByStatus (@PathVariable String status, @RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "10") int size){

        List<ImovelResponseDTO> allImoveis = this.imovelService.getImovelByStatus(page, size, status);
        return ResponseEntity.ok(allImoveis);
    }

    @GetMapping(path = "/user/imoveis/{id}")
    public ResponseEntity<ImovelDetailsRespondeDTO> getImovelDetails(@PathVariable Integer id) {
        ImovelDetailsRespondeDTO imovel = this.imovelService.getImovelDetails(id);
        return ResponseEntity.ok(imovel);
    }

    /*
        Criar um metodo para atualizar o status do imovel:
        De ativo para inativo, de pendente para ativo, etc
        **Funcional para apagar um imovel colocando ele como inativo
    */

    /*
        Criar um metodo para atualizar os dados do imovel
    */

    @DeleteMapping(path = "/admin/imoveis/{id}")
    public ResponseEntity deleteImovel(@PathVariable Integer id) {
        this.imovelService.deleteImovel(id);
        return ResponseEntity.noContent().build();
    }
}
